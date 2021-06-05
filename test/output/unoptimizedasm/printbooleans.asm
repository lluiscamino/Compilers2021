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
	subq	$280, %rsp
/*t1 = -1*/
	movq	$-1, %rax
	movq	%rax, -8(%rbp)
/*printBoolean(t1)*/
	movq	-8(%rbp), %rbx
	call	print_boolean
/*t2 = 0*/
	movq	$0, %rax
	movq	%rax, -16(%rbp)
/*printBoolean(t2)*/
	movq	-16(%rbp), %rbx
	call	print_boolean
/*t3 = -1*/
	movq	$-1, %rax
	movq	%rax, -24(%rbp)
/*param t3*/
	movq	-24(%rbp), %rax
	pushq	%rax
/*call s0*/
	call	t_printNot
/*t4 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*param t4*/
	movq	-32(%rbp), %rax
	pushq	%rax
/*call s0*/
	call	t_printNot
/*t5 = -1*/
	movq	$-1, %rax
	movq	%rax, -40(%rbp)
/*t6 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*t7 = t5 and t6*/
	movq	-40(%rbp), %rax
	movq	-48(%rbp), %rbx
	andq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*printBoolean(t7)*/
	movq	-56(%rbp), %rbx
	call	print_boolean
/*t8 = -1*/
	movq	$-1, %rax
	movq	%rax, -64(%rbp)
/*t9 = 0*/
	movq	$0, %rax
	movq	%rax, -72(%rbp)
/*t10 = t8 or t9*/
	movq	-64(%rbp), %rax
	movq	-72(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -80(%rbp)
/*printBoolean(t10)*/
	movq	-80(%rbp), %rbx
	call	print_boolean
/*t11 = 3*/
	movq	$3, %rax
	movq	%rax, -88(%rbp)
/*t12 = 5*/
	movq	$5, %rax
	movq	%rax, -96(%rbp)
/*if t11 > t12 goto e0*/
	movq	-88(%rbp), %rax
	movq	-96(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -104(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t13 = -1*/
	movq	$-1, %rax
	movq	%rax, -104(%rbp)
/*e1: skip*/
e1:
/*t14 = 7*/
	movq	$7, %rax
	movq	%rax, -112(%rbp)
/*t15 = 9*/
	movq	$9, %rax
	movq	%rax, -120(%rbp)
/*if t14 < t15 goto e2*/
	movq	-112(%rbp), %rax
	movq	-120(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e2
1:
/*t16 = 0*/
	movq	$0, %rax
	movq	%rax, -128(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t16 = -1*/
	movq	$-1, %rax
	movq	%rax, -128(%rbp)
/*e3: skip*/
e3:
/*t17 = t13 or t16*/
	movq	-104(%rbp), %rax
	movq	-128(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -136(%rbp)
/*printBoolean(t17)*/
	movq	-136(%rbp), %rbx
	call	print_boolean
/*t18 = -1*/
	movq	$-1, %rax
	movq	%rax, -144(%rbp)
/*t19 = not t18*/
	movq	-144(%rbp), %rbx
	notq	%rbx
	movq	%rbx, -152(%rbp)
/*t20 = 0*/
	movq	$0, %rax
	movq	%rax, -160(%rbp)
/*t21 = not t20*/
	movq	-160(%rbp), %rbx
	notq	%rbx
	movq	%rbx, -168(%rbp)
/*t22 = t19 or t21*/
	movq	-152(%rbp), %rax
	movq	-168(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -176(%rbp)
/*printBoolean(t22)*/
	movq	-176(%rbp), %rbx
	call	print_boolean
/*t23 = 3*/
	movq	$3, %rax
	movq	%rax, -184(%rbp)
/*t24 = 3*/
	movq	$3, %rax
	movq	%rax, -192(%rbp)
/*if t23 = t24 goto e4*/
	movq	-184(%rbp), %rax
	movq	-192(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t25 = 0*/
	movq	$0, %rax
	movq	%rax, -200(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t25 = -1*/
	movq	$-1, %rax
	movq	%rax, -200(%rbp)
/*e5: skip*/
e5:
/*printBoolean(t25)*/
	movq	-200(%rbp), %rbx
	call	print_boolean
/*t26 = 3*/
	movq	$3, %rax
	movq	%rax, -208(%rbp)
/*t27 = 6*/
	movq	$6, %rax
	movq	%rax, -216(%rbp)
/*if t26 = t27 goto e6*/
	movq	-208(%rbp), %rax
	movq	-216(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*t28 = 0*/
	movq	$0, %rax
	movq	%rax, -224(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t28 = -1*/
	movq	$-1, %rax
	movq	%rax, -224(%rbp)
/*e7: skip*/
e7:
/*printBoolean(t28)*/
	movq	-224(%rbp), %rbx
	call	print_boolean
/*t29 = 3*/
	movq	$3, %rax
	movq	%rax, -232(%rbp)
/*t30 = 5*/
	movq	$5, %rax
	movq	%rax, -240(%rbp)
/*if t29 != t30 goto e8*/
	movq	-232(%rbp), %rax
	movq	-240(%rbp), %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e8
1:
/*t31 = 0*/
	movq	$0, %rax
	movq	%rax, -248(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t31 = -1*/
	movq	$-1, %rax
	movq	%rax, -248(%rbp)
/*e9: skip*/
e9:
/*t32 = 4*/
	movq	$4, %rax
	movq	%rax, -256(%rbp)
/*t33 = 6*/
	movq	$6, %rax
	movq	%rax, -264(%rbp)
/*if t32 != t33 goto e10*/
	movq	-256(%rbp), %rax
	movq	-264(%rbp), %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e10
1:
/*t34 = 0*/
	movq	$0, %rax
	movq	%rax, -272(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t34 = -1*/
	movq	$-1, %rax
	movq	%rax, -272(%rbp)
/*e11: skip*/
e11:
/*t35 = t31 or t34*/
	movq	-248(%rbp), %rax
	movq	-272(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -280(%rbp)
/*printBoolean(t35)*/
	movq	-280(%rbp), %rbx
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
