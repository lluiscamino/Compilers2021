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
	subq	$67, %rsp
/*if a > b goto e0*/
	movq	16(%rbp), %rax
	movq	24(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t0 = 0*/
	movb	$0, %al
	movb	%al, -41(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t0 = -1*/
	movb	$-1, %al
	movb	%al, -41(%rbp)
/*e1: skip*/
e1:
/*if t0 = 0 goto e2*/
	movb	-41(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e2
1:
/*t1 = a*/
	movq	16(%rbp), %rax
	movq	%rax, -49(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t1 = b*/
	movq	24(%rbp), %rax
	movq	%rax, -49(%rbp)
/*e3: skip*/
e3:
/*max = t1*/
	movq	-49(%rbp), %rax
	movq	%rax, -40(%rbp)
/*if c > max goto e4*/
	movq	32(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e4
1:
/*t2 = 0*/
	movb	$0, %al
	movb	%al, -50(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t2 = -1*/
	movb	$-1, %al
	movb	%al, -50(%rbp)
/*e5: skip*/
e5:
/*if t2 = 0 goto e6*/
	movb	-50(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e6
1:
/*t3 = c*/
	movq	32(%rbp), %rax
	movq	%rax, -58(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t3 = max*/
	movq	-40(%rbp), %rax
	movq	%rax, -58(%rbp)
/*e7: skip*/
e7:
/*max = t3*/
	movq	-58(%rbp), %rax
	movq	%rax, -40(%rbp)
/*if d > max goto e8*/
	movq	40(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e8
1:
/*t4 = 0*/
	movb	$0, %al
	movb	%al, -59(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t4 = -1*/
	movb	$-1, %al
	movb	%al, -59(%rbp)
/*e9: skip*/
e9:
/*if t4 = 0 goto e10*/
	movb	-59(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e10
1:
/*t5 = d*/
	movq	40(%rbp), %rax
	movq	%rax, -67(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t5 = max*/
	movq	-40(%rbp), %rax
	movq	%rax, -67(%rbp)
/*e11: skip*/
e11:
/*max = t5*/
	movq	-67(%rbp), %rax
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
	subq	$250, %rsp
/*t6 = 0*/
	movb	$0, %al
	movb	%al, -1(%rbp)
/*if t6 = 0 goto e12*/
	movb	-1(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e12
1:
/*t8 = 4*/
	movq	$4, %rax
	movq	%rax, -17(%rbp)
/*t7 = t8*/
	movq	-17(%rbp), %rax
	movq	%rax, -9(%rbp)
/*goto e13*/
	jmp 	e13
/*e12: skip*/
e12:
/*t9 = 9*/
	movq	$9, %rax
	movq	%rax, -25(%rbp)
/*t7 = t9*/
	movq	-25(%rbp), %rax
	movq	%rax, -9(%rbp)
/*e13: skip*/
e13:
/*t10 = 3*/
	movq	$3, %rax
	movq	%rax, -33(%rbp)
/*t11 = - t10*/
	xorq 	%rax, %rax
	movq	-33(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -41(%rbp)
/*t12 = 4*/
	movq	$4, %rax
	movq	%rax, -49(%rbp)
/*t13 = 2*/
	movq	$2, %rax
	movq	%rax, -57(%rbp)
/*t14 = t12 + t13*/
	movq	-49(%rbp), %rax
	movq	-57(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -65(%rbp)
/*t15 = 4*/
	movq	$4, %rax
	movq	%rax, -73(%rbp)
/*param t7*/
	movq	-9(%rbp), %rax
	push	%rax
/*param t11*/
	movq	-41(%rbp), %rax
	push	%rax
/*param t14*/
	movq	-65(%rbp), %rax
	push	%rax
/*param t15*/
	movq	-73(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t16 = -1*/
	movb	$-1, %al
	movb	%al, -74(%rbp)
/*if t16 = 0 goto e14*/
	movb	-74(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e14
1:
/*t18 = 4*/
	movq	$4, %rax
	movq	%rax, -90(%rbp)
/*t17 = t18*/
	movq	-90(%rbp), %rax
	movq	%rax, -82(%rbp)
/*goto e15*/
	jmp 	e15
/*e14: skip*/
e14:
/*t19 = 9*/
	movq	$9, %rax
	movq	%rax, -98(%rbp)
/*t17 = t19*/
	movq	-98(%rbp), %rax
	movq	%rax, -82(%rbp)
/*e15: skip*/
e15:
/*t20 = 3*/
	movq	$3, %rax
	movq	%rax, -106(%rbp)
/*t21 = - t20*/
	xorq 	%rax, %rax
	movq	-106(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -114(%rbp)
/*t22 = 4*/
	movq	$4, %rax
	movq	%rax, -122(%rbp)
/*t23 = 2*/
	movq	$2, %rax
	movq	%rax, -130(%rbp)
/*t24 = t22 + t23*/
	movq	-122(%rbp), %rax
	movq	-130(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -138(%rbp)
/*t25 = 4*/
	movq	$4, %rax
	movq	%rax, -146(%rbp)
/*param t17*/
	movq	-82(%rbp), %rax
	push	%rax
/*param t21*/
	movq	-114(%rbp), %rax
	push	%rax
/*param t24*/
	movq	-138(%rbp), %rax
	push	%rax
/*param t25*/
	movq	-146(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t26 = 27*/
	movq	$27, %rax
	movq	%rax, -154(%rbp)
/*t27 = - t26*/
	xorq 	%rax, %rax
	movq	-154(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -162(%rbp)
/*t28 = 23*/
	movq	$23, %rax
	movq	%rax, -170(%rbp)
/*t29 = - t28*/
	xorq 	%rax, %rax
	movq	-170(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -178(%rbp)
/*t30 = 45*/
	movq	$45, %rax
	movq	%rax, -186(%rbp)
/*t31 = - t30*/
	xorq 	%rax, %rax
	movq	-186(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -194(%rbp)
/*t32 = 34*/
	movq	$34, %rax
	movq	%rax, -202(%rbp)
/*t33 = - t32*/
	xorq 	%rax, %rax
	movq	-202(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -210(%rbp)
/*param t27*/
	movq	-162(%rbp), %rax
	push	%rax
/*param t29*/
	movq	-178(%rbp), %rax
	push	%rax
/*param t31*/
	movq	-194(%rbp), %rax
	push	%rax
/*param t33*/
	movq	-210(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t34 = 23231*/
	movq	$23231, %rax
	movq	%rax, -218(%rbp)
/*t35 = - t34*/
	xorq 	%rax, %rax
	movq	-218(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -226(%rbp)
/*t36 = 12323*/
	movq	$12323, %rax
	movq	%rax, -234(%rbp)
/*t37 = 1212*/
	movq	$1212, %rax
	movq	%rax, -242(%rbp)
/*t38 = 897137132*/
	movq	$897137132, %rax
	movq	%rax, -250(%rbp)
/*param t35*/
	movq	-226(%rbp), %rax
	push	%rax
/*param t36*/
	movq	-234(%rbp), %rax
	push	%rax
/*param t37*/
	movq	-242(%rbp), %rax
	push	%rax
/*param t38*/
	movq	-250(%rbp), %rax
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
