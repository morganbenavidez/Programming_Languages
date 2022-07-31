;-------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;-------------------------------------------------------------------------
			.cdecls C,LIST,"msp430.h"   	; Include device header file
			.def RESET
			.text                   		; Assemble into program memory
			.retain                 		; Override ELF conditional linking and retain current section
			.retainrefs             		; Additionally retain any sections that have references to current section
;-------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer
;-------------------------------------------------------------------------
;-----  Your Sorting lab starts here -------------------------------------

;Memory allocation of arrays must be done prior to the RESET & StopWDT

ARY1 		.set 0x0200 		;Memory allocation ARY1
ARY1S 		.set 0x0210 		;Memory allocation ARY1S
ARY2 		.set 0x0220 		;Memory allocation ARY2
ARY2S 		.set 0x0230 		;Memory allocation ARY2S

			clr R3				;Clear Register
			clr R4 				;Clear Register
			clr R5 				;Clear Register
			clr R6 				;Clear Register
			clr R7				;Clear Register
			clr R8				;Clear Register
			clr R9				;Clear Register
			clr R10				;Clear Register
			clr R11				;Clear Register
			clr R12				;Clear Register
			clr R13				;Clear Register
			clr &0200h
			clr &0202h
			clr &0204h
			clr &0206h
			clr &0208h
			clr &020ah
			clr &020ch
			clr &020eh
			clr &0210h
			clr &0212h
			clr &0214h
			clr &0216h
			clr &0218h
			clr &021ah
			clr &021ch
			clr &021eh
			clr &0220h
			clr &0222h
			clr &0224h
			clr &0226h
			clr &0228h
			clr &022ah
			clr &022ch
			clr &022eh
			clr &0230h
			clr &0232h
			clr &0234h
			clr &0236h
			clr &0238h
			clr &023ah
			clr &023ch
			clr &023eh
			clr &0240h
			clr &0242h
			clr &0244h
			clr &0246h
			clr &0248h
			clr &024ah
			clr &024ch
			clr &024eh
			clr &0250h
			clr &0252h
			clr &0254h
			clr &0256h
			clr &0258h
			clr &025ah
			clr &025ch
			clr &025eh
			clr &0260h

SORT1 		mov.w #ARY1, R4 	;Initialize R4 to point to ARY1 in the memory
			mov.w #ARY1S, R6 	;Initialize R6 to point to ARY1S in the memory
								;where the sorted ARY1 will be stored
			call  #ArraySetup1 	;Create elements and store them in ARY1
 			call  #COPY 		;Copy the elements from the ARY1 space to ARY1S
								;space
			call  #SORTINGALG	;Calling Subroutine Sort with parameter passing
								;in R4 and R6
			;call  #SORT

SORT2 		mov.w #ARY2, R4 	;Initialize R4 to point to ARY2 in the memory
			mov.w #ARY2S, R6 	;Initialize R6 to point to ARY2S in the memory
								;where the sorted ARY2 will be stored
			call  #ArraySetup2 	;Create elements are store them in ARY2
			call  #COPY 		;Copy the elements from the ARY2 space to ARY1S
								;space
			call  #SORTINGALG 		;Calling Subroutine Sort with parameter passing
								;in R4 and R6

Mainloop 	jmp Mainloop 		;loop in place for ever



;Array element initialization Subroutine

ArraySetup1 mov.b #10,  0(R4) 	;Define the number of elements in the array
			mov.b #45,  1(R4) 	;store an element
			mov.b #-23, 2(R4) 	;store an element
			mov.b #-78, 3(R4) 	;store an element
			mov.b #32,  4(R4)	;store an element
			mov.b #89,  5(R4)	;store an element
			mov.b #-19, 6(R4)	;store an element
			mov.b #-99,	7(R4)	;store an element
			mov.b #73,  8(R4)	;store an element
			mov.b #-18, 9(R4)	;store an element
			mov.b #56,  10(R4)	;store an element

			;(DO THIS) store the rest of the 10 elements
			ret



;Array element initialization Subroutine 2

ArraySetup2 mov.b #10,  0(R4) 	;Define the number of elements in the array
			mov.b #22,  1(R4) 	;store an element
			mov.b #45,  2(R4) 	;store an element
			mov.b #21,  3(R4) 	;store an element
			mov.b #-39, 4(R4)	;store an element
			mov.b #-63, 5(R4)	;store an element
			mov.b #69,  6(R4)	;store an element
			mov.b #72,	7(R4)	;store an element
			mov.b #41,  8(R4)	;store an element
			mov.b #28,  9(R4)	;store an element
			mov.b #-28, 10(R4)	;store an element
			;(DO THIS) store the rest of the 10 elements
			ret



;Copy original Array to allocated Array-Sorted space

COPY 		mov.b 0(R4), R10 	;save n (number of elements) in R10
			inc.b R10 			;increment by 1 to account for the byte n to be
								;copied as well
			mov.w R4, R5 		;copy R4 to R5 so we keep R4 unchanged for later
								;use
			mov.w R6, R7 		;copy R6 to R7 so we keep R6 unchanged for later
								;use
			;ret

LP 			mov.b @R5+, 0(R7) 	;copy elements using R5/R7 as pointers
			inc.w R7
			dec R10
			jnz LP
			ret


;Sort the copy of Array saved in the allocated Array-Sorted space, while keeping
;original Array unchanged
;replace the following two lines with your actual sorting algorithm.
;


;BUBBLE SORT ATTEMPT

SORTINGALG
				mov.b @R4, R15			;Took out '+' after R4
				mov.b @R6+, R8
				;inc   R6				;Commented this out
				;inc R4 ;just did this
				;inc R6 ;just did this
				mov.w R6, R13			;Added this
				dec R8
				;mov.w R4, R9 ;just did this			;Added this


OUTERLOOP		;mov.b R10, R9
				;mov.b

				mov.w R13, R6

				;mov.w R9, R4 ;just did this
				mov.w R8, R14
				;mov.b @R6, R9

INNERLOOP		mov.b @R6+, R11
				mov.b @R6, R12
				cmp.b R11,R12
				jge SKIP				;Commented this out to test
				;mov.b R12, R13
				mov.b R12, -1(R6)
				mov.b R11, 0(R6)
				;mov.b R11, R12

SKIP			;mov.b R12, R11
				dec.b R14
				jnz INNERLOOP

				dec.b R15
				jnz OUTERLOOP
				ret




; $$$ TRYING TO BYPASS WITH NEGATIVE

;SORTA		mov.b @R4+, R11
;			mov.b @R4,  R12
;;			mov.b R12,  R13		;because dst will change
;			clrn
;			sub	  R11, R13		;because dst will change
;			jn	  SWAP
;			setz
;			jz	  NORMAL
;			;cmp.b R11, R12
;			;jz 	  SKIP
;			;jl	  SKIP
;SWAP		clr R13
;			mov.b R12, R13
;			mov.b R11, R12
;			mov.b R13, R11
;
;NORMAL		mov.b R11, 0(R6)
;			mov.b R12, 1(R6)
;			mov.b @R6+, R14
;			clr	  R14
;			clr   R13
;			clr   R12
;			clr	  R11

;			dec.b R10
;			jnz   SORTA
;			ret






; $$$ THIS GETS RID OF 10 AND MOVES THEM IN ORDER

;SORTA		mov.b @R4+, R11
;			mov.b @R4,  R12
;			cmp.b R11, R12
;			jz 	  SKIP
;			;jl	  SKIP
;			mov.b R12, R13
;			mov.b R11, R12
;			mov.b R13, R11
;SKIP		mov.b R11, 0(R6)
;			mov.b R12, 1(R6)
;			clr	  R13
;			mov.b @R6+, R13
;			clr   R13
;			clr   R12
;			clr	  R11
;			dec.b R10
;			jnz   SORTA
;			ret



;  $$$ THIS PLACES EVERYTHING IN THE 210 ARRAY, JUST MOVES IT $$$
;SORTA		mov.b @R4+, 0(R6)
;			mov.b @R4,  1(R6)
;			mov.b @R6+, R12
;			clr   R12
;			dec.b R10
;			jnz   SORTA
;			ret




;SORTA		mov.b @R4+, 0(R6)
;			mov.b 0(R6),R11
;			mov.b @R6+, R12
;			clr	  R11
;			mov.b @R4+, R11
;			mov.b R11, R13
;			not.jn SKIP
;			jmp NOTHING
;SKIP		mov.b R11, -1(R6)
;			mov.b R12, 0(R6)
;			;mov.b @R6+, R13
;NOTHING		clr R11
;			clr R12
;			clr R13
;			dec.b R10
;			jnz SORTA
;			ret








;SORTA		mov.b @R4+, 0(R6)
;			mov.b 0(R6),R11
;			mov.b @R6+, R12
;			mov.b @R4, 0(R6)
;			mov.b @R6,  R13
;			sub.b  R13, R12
;			jn    SKIP
;			jmp   NOTHING
;			dec.b R10
;			jnz	  SORTA
;			ret
;SKIP		mov.b -1(R6), R14
;			mov.b @R6, -1(R6)
;			mov.b R14, (R6)
;NOTHING		dec.b R10
;			jnz	  SORTA
;			ret

;SORT		mov.b @R6+, R11
;			mov.b @R6, 	R12
;			sub.b   R12,  R11
;			mov.b R11,  R13
;			ret

;SORT		mov.b @R4+, R11
;			mov.b @R4+, R12
;			dec.b R11
;LOOP		cmp.b @R4+, R12
;			jge	  SKIP
;			swpb  R12
;			;mov.b -1(R4), R12
;SKIP		dec.b R11
;			jnz   LOOP
;			ret


;SORT		mov.b @R4+, R11
;			cmp.b R11, (R4)
;			jl	  SKIP  		;Zero bit is never set
;			mov.b @R4, R12
;			mov.b R11, 0(R4)
;			mov.b R12, R11
;			;mov.b 1(R4), 0(R6)
;SKIP		dec.b  R10
;			clr R11
;			clr R12
;			jnz	   SORT
;			ret

;SORT 		;mov.b  1(R6), R11
;			mov.b  @R6+, R11
;			cmp.b  @R6, R11
;			jge	   SKIP
;			mov.b  @R6, R12
;			mov.b  R11, (R6)
;			mov.b  R12, R11
;SKIP		dec.w  R10
;			jnz	   SORT
;			ret
;			;cmp index, index+1
;			;if index is bigger, swap
;			;
;			;ret



;To bubble sort, you need to scan the array n-1 times,
;In every scan, you compare from top down each two consecutive elements,
;and you swap them if they are not in ascending order.
;Notice that in the first scan you get the largest element
;(no matter where it is in the array) pushed all the way to the bottom.
;So your next scan should be n-1 iterations, and then n-2 and so on.
;So every time you come back to the top of the array for a new scan, your
;n (the number of comparisons) must be decremented by 1.
;In the last scan, you need only one comparison.
;Hints:
;Your sorting algorithm starts with R6 as a pointer to the array
;you need to save n (number of elements) in R8, then decrement it by 1 (n-1)
;to become the number of comparisons.
;Copy R6 to R7 so you keep R6 unchanged as it points to the top of the
;array for every new scan.
;Copy n-1 to R9 and use R9 as a loop counter, while keeping the current n-
;1 value in R8 for the next scan.
;In the scan loop get an element and auto increment pointer R7, then get
;next element without changing R7.
;Compare the two elements, if not in ascending order, swap them.
;Repeat the scan from the top as pointed to by (R6), and every time
;decrement the number of comparisons (R8).
;-----  Your Sorting lab ends here   -------------------------------------
;------
;-------------------------------------------------------------------------
;------
;-------------------------------------------------------------------------
;------
;Stack Pointer definition
			.global __STACK_END
			.sect .stack
;-------------------------------------------------------------------------
;------
;Interrupt Vectors
			.sect   ".reset"    ;MSP430 RESET Vector
			.short  RESET
