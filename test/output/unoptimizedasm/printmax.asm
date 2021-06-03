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
/*t_printMaxInteger: skip*/
t_printMaxInteger:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$88, %rsp
/*if a > b goto e0*/
	movq	16(%rbp), %rax
	movq	24(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t0 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t0 = -1*/
	movq	$-1, %rax
	movq	%rax, -48(%rbp)
/*e1: skip*/
e1:
/*if t0 = 0 goto e2*/
	movq	-48(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e2
1:
/*t1 = a*/
	movq	16(%rbp), %rax
	movq	%rax, -56(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t1 = b*/
	movq	24(%rbp), %rax
	movq	%rax, -56(%rbp)
/*e3: skip*/
e3:
/*max = t1*/
	movq	-56(%rbp), %rax
	movq	%rax, -40(%rbp)
/*if c > max goto e4*/
	movq	32(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e4
1:
/*t2 = 0*/
	movq	$0, %rax
	movq	%rax, -64(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t2 = -1*/
	movq	$-1, %rax
	movq	%rax, -64(%rbp)
/*e5: skip*/
e5:
/*if t2 = 0 goto e6*/
	movq	-64(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*t3 = c*/
	movq	32(%rbp), %rax
	movq	%rax, -72(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t3 = max*/
	movq	-40(%rbp), %rax
	movq	%rax, -72(%rbp)
/*e7: skip*/
e7:
/*max = t3*/
	movq	-72(%rbp), %rax
	movq	%rax, -40(%rbp)
/*if d > max goto e8*/
	movq	40(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e8
1:
/*t4 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t4 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e9: skip*/
e9:
/*if t4 = 0 goto e10*/
	movq	-80(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e10
1:
/*t5 = d*/
	movq	40(%rbp), %rax
	movq	%rax, -88(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t5 = max*/
	movq	-40(%rbp), %rax
	movq	%rax, -88(%rbp)
/*e11: skip*/
e11:
/*max = t5*/
	movq	-88(%rbp), %rax
	movq	%rax, -40(%rbp)
/*printInt(max)*/
	movq	-40(%rbp), %rdi
	call	print_uint64
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$264, %rsp
/*t6 = 0*/
	movq	$0, %rax
	movq	%rax, -8(%rbp)
/*if t6 = 0 goto e12*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e12
1:
/*t8 = 4*/
	movq	$4, %rax
	movq	%rax, -24(%rbp)
/*t7 = t8*/
	movq	-24(%rbp), %rax
	movq	%rax, -16(%rbp)
/*goto e13*/
	jmp 	e13
/*e12: skip*/
e12:
/*t9 = 9*/
	movq	$9, %rax
	movq	%rax, -32(%rbp)
/*t7 = t9*/
	movq	-32(%rbp), %rax
	movq	%rax, -16(%rbp)
/*e13: skip*/
e13:
/*t10 = 3*/
	movq	$3, %rax
	movq	%rax, -40(%rbp)
/*t11 = - t10*/
	xorq 	%rax, %rax
	movq	-40(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t12 = 4*/
	movq	$4, %rax
	movq	%rax, -56(%rbp)
/*t13 = 2*/
	movq	$2, %rax
	movq	%rax, -64(%rbp)
/*t14 = t12 + t13*/
	movq	-56(%rbp), %rax
	movq	-64(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t15 = 4*/
	movq	$4, %rax
	movq	%rax, -80(%rbp)
/*param_s t7*/
	movq	-16(%rbp), %rax
	push	%rax
/*param_s t11*/
	movq	-48(%rbp), %rax
	push	%rax
/*param_s t14*/
	movq	-72(%rbp), %rax
	push	%rax
/*param_s t15*/
	movq	-80(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t16 = -1*/
	movq	$-1, %rax
	movq	%rax, -88(%rbp)
/*if t16 = 0 goto e14*/
	movq	-88(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e14
1:
/*t18 = 4*/
	movq	$4, %rax
	movq	%rax, -104(%rbp)
/*t17 = t18*/
	movq	-104(%rbp), %rax
	movq	%rax, -96(%rbp)
/*goto e15*/
	jmp 	e15
/*e14: skip*/
e14:
/*t19 = 9*/
	movq	$9, %rax
	movq	%rax, -112(%rbp)
/*t17 = t19*/
	movq	-112(%rbp), %rax
	movq	%rax, -96(%rbp)
/*e15: skip*/
e15:
/*t20 = 3*/
	movq	$3, %rax
	movq	%rax, -120(%rbp)
/*t21 = - t20*/
	xorq 	%rax, %rax
	movq	-120(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*t22 = 4*/
	movq	$4, %rax
	movq	%rax, -136(%rbp)
/*t23 = 2*/
	movq	$2, %rax
	movq	%rax, -144(%rbp)
/*t24 = t22 + t23*/
	movq	-136(%rbp), %rax
	movq	-144(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t25 = 4*/
	movq	$4, %rax
	movq	%rax, -160(%rbp)
/*param_s t17*/
	movq	-96(%rbp), %rax
	push	%rax
/*param_s t21*/
	movq	-128(%rbp), %rax
	push	%rax
/*param_s t24*/
	movq	-152(%rbp), %rax
	push	%rax
/*param_s t25*/
	movq	-160(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t26 = 27*/
	movq	$27, %rax
	movq	%rax, -168(%rbp)
/*t27 = - t26*/
	xorq 	%rax, %rax
	movq	-168(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -176(%rbp)
/*t28 = 23*/
	movq	$23, %rax
	movq	%rax, -184(%rbp)
/*t29 = - t28*/
	xorq 	%rax, %rax
	movq	-184(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -192(%rbp)
/*t30 = 45*/
	movq	$45, %rax
	movq	%rax, -200(%rbp)
/*t31 = - t30*/
	xorq 	%rax, %rax
	movq	-200(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -208(%rbp)
/*t32 = 34*/
	movq	$34, %rax
	movq	%rax, -216(%rbp)
/*t33 = - t32*/
	xorq 	%rax, %rax
	movq	-216(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -224(%rbp)
/*param_s t27*/
	movq	-176(%rbp), %rax
	push	%rax
/*param_s t29*/
	movq	-192(%rbp), %rax
	push	%rax
/*param_s t31*/
	movq	-208(%rbp), %rax
	push	%rax
/*param_s t33*/
	movq	-224(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t34 = 23231*/
	movq	$23231, %rax
	movq	%rax, -232(%rbp)
/*t35 = - t34*/
	xorq 	%rax, %rax
	movq	-232(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -240(%rbp)
/*t36 = 12323*/
	movq	$12323, %rax
	movq	%rax, -248(%rbp)
/*t37 = 1212*/
	movq	$1212, %rax
	movq	%rax, -256(%rbp)
/*t38 = 897137132*/
	movq	$897137132, %rax
	movq	%rax, -264(%rbp)
/*param_s t35*/
	movq	-240(%rbp), %rax
	push	%rax
/*param_s t36*/
	movq	-248(%rbp), %rax
	push	%rax
/*param_s t37*/
	movq	-256(%rbp), %rax
	push	%rax
/*param_s t38*/
	movq	-264(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

print_uint64:
	lea 	-1(%rsp), %rsi
	movb	$'\n', (%rsi)
	mov 	$10, %ecx
	movl	%edi, %ebx
	testl	%edi, %edi
	jns 	.print_uint64_positive
	neg 	%edi

	.print_uint64_positive:
		mov 	%rdi, %rax

	.Ltoascii_digit:
		xor 	%edx, %edx
		div 	%rcx
		add 	$'0', %edx
		dec 	%rsi
		mov 	%dl, (%rsi)
		test	%rax, %rax
		jnz 	.Ltoascii_digit
		testl	%ebx, %ebx
		jns 	.print_uint64_end
		xor 	%edx, %edx
		div 	%rcx
		add 	$'-', %edx
		dec 	%rsi
		mov 	%dl, (%rsi)
		test 	%rax, %rax

	.print_uint64_end:
		mov 	$0x02000004, %eax
		mov 	$1, %edi
		mov 	%rsp, %rdx
		sub 	%rsi, %rdx
		syscall
		ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
