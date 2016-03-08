.code16                 
.text                   
mov %cs,%ax
   mov %ax,%ds
   mov %ax,%es
       call DispStr        
       jmp .               #inf loop
   DispStr:
   mov $msg, %ax
   mov %ax,%bp         #ES:BP = long
   mov $16,%cx         #CX =length
   mov $0x1301,%ax     #AH = 13, AL = 01h
   mov $0x00c,%bx      
   mov $0,%dl
       int $0x10       
       ret
   msg:.ascii "Hello, Booter !"
   .org 510            
   .word 0xaa55        
