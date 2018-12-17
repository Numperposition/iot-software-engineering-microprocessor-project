#include <8051.h>
#include <string.h>

void init();
void clear();
void setCursor(unsigned char R0, unsigned char R1);
void comnWrt(unsigned char A);
void putChar(unsigned char A);
void ready();
void outputInfo(int);
char ch, rx;
unsigned int count = 0, i = 0, num = 0, VALUE = 0;
unsigned char buffer[30];   
unsigned char tag = 0, beeflag = 0;

void enterTicketNo() ;

void timer0() __interrupt(TF0_VECTOR) //timer 0 interrupt used to count 5s and call the buzzer
{
	
	TH0 = 0XEE;  //initial the value
	TL0 = 0X00;
	if(beeflag == 1)  //if ticket number is invalid, call the buzzer.
	{
		if(P1_1 == 0)
		  P1_1 = 1;
		else if(P1_1 == 1)
		  P1_1 = 0;
	}
	num++;
}

void serisr() __interrupt(SI0_VECTOR) //serier interrupt used to send and receive data
{
	
	if(TI == 1 && ch != '\0')  //transmit data to computer. If no new char comes, do not transmit
	{
		TI = 0;
		SBUF = ch;
		ch = '\0'; 
	
	}
	else if(RI == 1) //receive data from computer
	{
		if(tag == 0) 
		{
			rx = SBUF; //receive the first char of a string to confirm which action should be performed. 
			tag = 1;
		}
		else if(SBUF != '0')  //we set each string is ended with '0'.
		{
			buffer[i] = SBUF;
			i++;
		}
		else if(SBUF == '0')
		{
			buffer[i] = '\0';
		}
		RI = 0;
	}
}

void delay(int n) 
{
	int i = 0;
	for(i = 0; i < n; i++) ;
}
void enterTicketNo()  //a method to acquire button input from user, and send corresponding char to PC.
{
	unsigned char K1_flag = 0;
    unsigned char K2_flag = 0;
    unsigned char K3_flag = 0;
    unsigned char K4_flag = 0;
	while(1)
	{
		if(P3_2 == 0)
		{
			K1_flag = 1;
			delay(1000);
		}
		else if(P3_2 == 1 && K1_flag == 1)
		{
			K1_flag = 0;
			ch = '1';
			TI = 1;
			count++;
		}
		else if(P3_3 == 0)
		{
			K2_flag = 1;
			delay(1000);
		}
		else if(P3_3 == 1 && K2_flag == 1)
		{
			K2_flag = 0;
			ch = '2';
			TI = 1;
			count++;
		}
		else if(P3_4 == 0)
		{
			K3_flag = 1;
			delay(1000);
		}
		else if(P3_4 == 1 && K3_flag == 1)
		{
			K3_flag = 0;
			ch = '3';
			TI = 1;
			count++;
		}
		else if(P1_2 == 0)
		{
			K4_flag = 1;
			delay(1000);
		}
		else if(P1_2 == 1 && K4_flag == 1)
		{
			K4_flag = 0;
			ch = '4';
			TI = 1;
			count++;
		}

			if(count == VALUE) //send number of VALUE chars
			{
				count = 0;
				return ;
			}
		
	}
}
void checkTicket()
{
	while(1)
	{
		if(rx == '1')  //adult, child, senior vaild ticket. 
	   {
		
		delay(300);   //call a delay to wait buffer to receive all chars.
		rx = '0';
		P2_2 = 1;
		P2_3 = 0;
		TR0 = 1;   //start timer 0
		init();
		outputInfo(9); 
		return ;
	  }
	   if(rx == '2') //student vaild ticket.
	  {
		
		delay(300);
		rx = '0';
		P2_2 = 0;
	    strcpy(buffer, "Please wait...");
	    init();
		outputInfo(14);
	    VALUE = 4;
	    enterTicketNo();
	    strcpy(buffer, "");
	    tag = 0;
	    i = 0;
		continue;
	//	return ;
	  }
	  if(rx == '3')  //invaild ticket.
	  {
	  	delay(300);
	  	rx = '0';
	    if(P2_2 == 0)
	      P2_2 = 1;
	  	P2_0 = 0;
	  	beeflag = 1;
	  	TR0 = 1;  //start timer 0
	  	return ;
	  }
	}
	
	
}
void outputInfo(int n)  //a method to put chars to lcd1602 to display.
{
	unsigned char j;
	
	for(j = 0; j < n; j++)
	{
		setCursor(j,0); 
		putChar(buffer[j]);
	}
	if(n < 14)
	{
		for(j = n; buffer[j] != '\0'; j++)
	  {
	  	if(j >= 16 + n)
	  	  break;
		setCursor(j - n, 1); 
		putChar(buffer[j]);
	  }
	}
	
}

void init()   //initial lcd1602
{
	unsigned char A;
	
	A = 0x38;	comnWrt(A);
	A = 0x0C;	comnWrt(A);
	A = 0x06;	comnWrt(A);
	A = 0x01;	comnWrt(A);
	A = 0x80;	comnWrt(A);
}

void setCursor(unsigned char R0, unsigned char R1) //set the cursor 
{
	unsigned char A;
	
	R0 = R0 & 0x0F;
	R1 = R1 & 0X01;
	A = R1;
	if(A != 0) R0 = R0 | 0x40;
	A = R0;
	A = A | 0x80;
	comnWrt(A);
}

void comnWrt(unsigned char A) {
	ready(); 
	P0 = A; // LCDDB = A;
	P1_5 = 0; // RS = 0;
	P1_6 = 0; // RW = 0;
	P1_7 = 1;; // EN = 1;
	P1_7 = 0; // EN = 0;
}

void putChar(unsigned char A) {
	ready();
	P0 = A; // LCDDB = A;
	P1_5 = 1; // RS = 1;
	P1_6 = 0; // RW = 0;
	P1_7 = 1; // EN = 1;
	P1_7 = 0; // EN = 0;
}
    
void ready() {
	unsigned char i;
	
	P0 = 0xFF; // LCDDB = 0xFF;
	P1_5 = 0; // RS = 0;
	P1_6 = 1; // RW = 1;
	P1_7 = 1; // EN = 1;
	for(i = 0; i < 255; i++)
		if (P0_7 == 0) P1_7 = 0;
	P1_7 = 0;
}

void main()
{
    
//	unsigned char i = 0;
    
	TMOD = 0x21; // set T1 mode 2, T0 mode 0 
	SCON = 0x50; // uart: mode 1, 8-bit, 1-stop
	IE = 0x92;   // enable global & serial interrupt & timer0 10010010b
	TH1 = 0xFD; // set 9600 Baud

	TH0 = 0XEE;  //set timer 0
	TL0 = 0X00; 
	while(1)
	{
		VALUE = 8;
		strcpy(buffer, "Welcome!Enter ticket ID.");
	    init(); 
	    
	    outputInfo(8);
	    strcpy(buffer, "");
		TR1 = 1;	//start serial interrupt
	    enterTicketNo();
	    checkTicket();
	    
	    TR1 = 0;   //after transmition, stop serial interrupt
	    
	    while(1)
	    {
	      if(num == 1000)
	     {
	  	   if(P2_3 == 0)
	  	    P2_3 = 1;
	  	   if(P2_2 == 0)
	  	    P2_3 = 1;
	  	   if(P2_0 == 0)
	  	    P2_0 = 1;
	  	   TR0 = 0;
	  	   num = 0;
	  	   strcpy(buffer, "");
	  	   i = 0;
	  	   tag = 0;
	  	   beeflag = 0;
	  	   break;
	     }	
	     
	   }
	}
	
} 

