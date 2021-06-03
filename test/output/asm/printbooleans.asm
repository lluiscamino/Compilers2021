.section	__TEXT, __text
	.globl	_main
	.globl	read_string
	.globl	compare_strings
	.globl	print_boolean
	.globl	string_length
	.globl	print_string
	.globl	print_uint64
_main:
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	%rbp, (%rsi)
/*init*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
/*t_printNot: skip*/
t_printNot:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$16, %rsp
/*t0 = not value*/
	movq	16(%rbp), %rbx
	notq	%rbx
	movq	%rbx, -16(%rbp)
/*printBoolean(t0)*/
	movq	-16(%rbp), %rbx
	call	print_boolean
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*printBoolean(0)*/
	movq	$0, %rbx
	call	print_boolean
/*param_s -1*/
	movq	$-1, %rax
	push	%rax
/*call s0*/
	call	t_printNot
/*param_s 0*/
	movq	$0, %rax
	push	%rax
/*call s0*/
	call	t_printNot
/*printBoolean(0)*/
	movq	$0, %rbx
	call	print_boolean
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*goto e2*/
	jmp 	e2
/*e2: skip*/
e2:
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*goto e4*/
	jmp 	e4
/*e4: skip*/
e4:
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*goto e7*/
	jmp 	e7
/*e7: skip*/
e7:
/*printBoolean(0)*/
	movq	$0, %rbx
	call	print_boolean
/*goto e10*/
	jmp 	e10
/*e10: skip*/
e10:
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/**
 * Prints a boolean to stdout
 * Params:
 * - %rbx: Boolean value
 */
print_boolean:
	testl	%ebx, %ebx
	jnz 	.print_boolean_true
	movq	decl_1@GOTPCREL(%rip), %rsi
	jmp 	.print_boolean_end
	.print_boolean_true:
		movq	decl_0@GOTPCREL(%rip), %rsi
	.print_boolean_end:
		call 	print_string
		ret

/**
 * Returns a string's length (saves to %rdx)
 * Params:
 * - %rsi: String address
 * https://stackoverflow.com/questions/60482733/how-to-traverse-a-string-in-assembly-until-i-reach-null-strlen-loop
 */
string_length:
	lea 	-1(%rsi), %rdx
	.Lloop:
		inc 	%rdx
		cmpb	$0, (%rdx)
		jne 	.Lloop
	sub 	%rsi, %rdx
	ret

/**
 * Prints a string to stdout
 * Params:
 * - %rsi: String address
 */
print_string:
	call	string_length
	mov 	$0x02000004, %rax
	mov 	$1, %rdi
	syscall
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
