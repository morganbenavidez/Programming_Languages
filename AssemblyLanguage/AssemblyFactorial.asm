;-------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;
;
;-------------------------------------------------------------------------
			.cdecls C,LIST,"msp430.h"       ; Include device header file
;-------------------------------------------------------------------------
			.def	RESET
			.text                           ; Assemble into program memory
			.retain                         ; Override ELF conditiona linking
											; and retain current section
			.retainrefs                     ; Additionally retain any sections
											; that have references to current
											; section
;-------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer
;-------------------------------------------------------------------------
;-------------------------------------------------------------------------
; your lab3 code is here between double dashed lines
; below is the
Lab3 		mov.w #-7, R4 		;set up the initial a value in R4
		clr.w R5
		clr.w R6
		clr.w R7
		clr.w R8

Xcalc 		mov.w R4, R5 		;copy the a value into R5
		call  #ABSOL 		;computer the absolute value of a in R5

Summation 	mov.w R5, R13
		mov.w R5, R6
		mov.w R5, R15 		;starting the upper limit with value a of the summation 						;in R6
		inc.w R15
		clr   R14

SumLoop	tst.w R15
		jz	  SumEnd
		call  #FACTO 		;get the factorial value of R6 and save in R6
					;finish Xcalc by doubling the value and adding it to 					;accumulator R8,
					;repeat the loop with a-1, a-2 (in R5) till         						;lower value a=0
		dec.w R15		;save the Xcalc results in R5
		add.w R6, R14
		dec.w R13
		mov.w R13, R5
		mov.w R5, R6
		jmp   SumLoop

SumEnd		call  #Fcalc


					;finish Fcalc by adding the constant 50 and
					;dividing by 4 (hint shift twice to the right with 						;carry=0)
loop 		jmp loop 		;loop in place
					;Absolute subroutine take a value form R5 and converts 						;it to its absolute value

Fcalc: 	mov.w R14, R7 		;start F calculation
		rla.w R7
		rla.w R7
		sub.w R14, R7
		rla.w R7
		rla.w R7
		rla.w R7
		sub.w R14, R7
		sub.w R14, R7
		sub.w R14, R7
		add.w #25, R7
		rra.w R7
		rra.w R7
		rra.w R7


ABSOL:
		tst R5
		jn twoscompl
		ret

twoscompl 	inv R5
		inc R5
ABSOLend 	ret

;Factorial subroutine takes number n form R6 and compute/save n! in R6
;You need to replace the NOP with your actual n! calculation as given in class
;You must push/pop all registers


FACTO:		tst.w R5
		jz	  Zero
		jn	  Neg

			

Loop		dec.w R5
		jz	  FACTOend
		call  #MULT ;R5 x R6
		jmp   Loop

Zero		add.w #1, R14
		jmp	  FACTOend

Neg		clr.w R6
		jmp	  FACTOend

FACTOend 	ret

;write the factorial subroutine
;you start with value n in R6, then multiply with n-1, n-2, ..1
;use the MULT subroutine to multiply R5 to R6 registers



;The multiplier subroutine based on shift and add
;It takes R5 as the multiplier and R6 as the multiplicand
;to avoid multiplication overflow, both R5 and R6 should                                     
;be limited to one byte and thus  ANDed with 0X00FF.
;but due to factorial calculation, we will not mask R6 to let it grow beyond 255

MULT:
		push.w R5								;
		push.w R7;
		push.w R8;
		mov.w #8, R8 		;8 bit multiplication,so we loop 8 times
		clr.w R7		;additive accumulator should start with zero
		and.w #0x00FF, R5 	;clear upper 8 bits of multiplier
				        ;clear upper 8 bits of multiplicand4

nextbit 	rrc.w R5 		;shift multiplier bits one at a time to the carry
		jnc twice 		;if no carry skip the add

addmore 	add.w R6, R7 		;add a copy of the multiplicand to the accumulator

twice 		add.w R6, R6 		;multiplicand times 2, (shifted 1 bit left)
		dec.w R8 		;dec loop counter
		jnz nextbit 		;jump to check next bit of the multiplier
		mov.w R7, R6 		;save the result in R6
		pop.w R8;
		pop.w R7;
		pop.w R5;

MULTend 	ret




;end of you code between double dashed lines
;-------------------------------------------------------------------------
;-------------------------------------------------------------------------
;-------------------------------------------------------------------------
;           Stack Pointer definition
;-------------------------------------------------------------------------
		.global __STACK_END
		.sect .stack
;-------------------------------------------------------------------------
;           Interrupt Vectors
;-------------------------------------------------------------------------
		.sect   ".reset"                ; MSP430 RESET Vector
		.short  RESET
