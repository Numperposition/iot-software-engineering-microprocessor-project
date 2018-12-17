1. This file will help you know the environment our operations need and how to make our H&S system get ready for using.
2. Instruction.
   (1) Environment: Java SE/EE jdk 1.7/1.8.
   (2) Compile way 
        (a): CMD directly compile;
        (b): Use Eclipse platform to get start.
        Attention: Both ways need to have the library reference jar for the RXTX library.
   (3)Do not modify the delay of the I/O we define in the java code.
3. Set up steps.
   For our Software system (java files):
   (1) First, you may download our java package from web and also with the driver of RXTX.jar.
   (2) Then, here we use eclipse as example, since we make connection in the eclipse with the reference library jar of RXTXcomm.
   (3) Open up the eclipse, and settle a new subject.
   (4) And then get into the workspace (which is used to save your source code) find the SRC folder for your new project, and then copy the .java document which is in "code" folder into this folder, and also copy all other left documents which is in "files" folder like £¨.txt or .png erc.£©into the space which is at the same level as SRC folder.
   (5) Next, go back to the eclipse and at the operation space at left space of the frame, press the new project library and add the reference library ¡ª>RXTXcomm.jar.
   (6) After all above have been done, we will get our Hardware connection:
   For our Hardware (.c code)
          (1) set the port (like COM3¡­) as the same as your own PC port:(go to the operation platform in your computer management center).
          (2) set the right baud rate in the java filed.(which is 9600 in our program)
          (3) then use USB port to make connection is OK.
          
4. Done
     All above will make all preparation for your starting using our system.
     About how to use, please see the usermanual. 
Notice: Before run the java software, please make sure 8051 microprocessor is turned on.

