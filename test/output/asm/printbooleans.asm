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
	subq	$104, %rsp
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
/*t7 = 0*/
	movq	$0, %rax
	movq	%rax, -8(%rbp)
/*printBoolean(t7)*/
	movq	-8(%rbp), %rbx
	call	print_boolean
/*t10 = -1*/
	movq	$-1, %rax
	movq	%rax, -16(%rbp)
/*printBoolean(t10)*/
	movq	-16(%rbp), %rbx
	call	print_boolean
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*goto e1*/
	jmp 	e1
/*t13 = -1*/
	movq	$-1, %rax
	movq	%rax, -24(%rbp)
/*e1: skip*/
e1:
/*goto e2*/
	jmp 	e2
/*t16 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t16 = -1*/
	movq	$-1, %rax
	movq	%rax, -32(%rbp)
/*e3: skip*/
e3:
/*t17 = t13 or t16*/
	movq	-24(%rbp), %rax
	movq	-32(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -40(%rbp)
/*printBoolean(t17)*/
	movq	-40(%rbp), %rbx
	call	print_boolean
/*t19 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*t21 = -1*/
	movq	$-1, %rax
	movq	%rax, -56(%rbp)
/*t22 = t19 or t21*/
	movq	-48(%rbp), %rax
	movq	-56(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -64(%rbp)
/*printBoolean(t22)*/
	movq	-64(%rbp), %rbx
	call	print_boolean
/*goto e4*/
	jmp 	e4
/*t25 = 0*/
	movq	$0, %rax
	movq	%rax, -72(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t25 = -1*/
	movq	$-1, %rax
	movq	%rax, -72(%rbp)
/*e5: skip*/
e5:
/*printBoolean(t25)*/
	movq	-72(%rbp), %rbx
	call	print_boolean
/*t28 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e7*/
	jmp 	e7
/*t28 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e7: skip*/
e7:
/*printBoolean(t28)*/
	movq	-80(%rbp), %rbx
	call	print_boolean
/*goto e8*/
	jmp 	e8
/*t31 = 0*/
	movq	$0, %rax
	movq	%rax, -88(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t31 = -1*/
	movq	$-1, %rax
	movq	%rax, -88(%rbp)
/*e9: skip*/
e9:
/*goto e10*/
	jmp 	e10
/*t34 = 0*/
	movq	$0, %rax
	movq	%rax, -96(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t34 = -1*/
	movq	$-1, %rax
	movq	%rax, -96(%rbp)
/*e11: skip*/
e11:
/*t35 = t31 or t34*/
	movq	-88(%rbp), %rax
	movq	-96(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -104(%rbp)
/*printBoolean(t35)*/
	movq	-104(%rbp), %rbx
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
