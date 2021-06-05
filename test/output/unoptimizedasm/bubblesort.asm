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
/*t_bubbleSort: skip*/
t_bubbleSort:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$168, %rsp
/*t0 = -1*/
	movq	$-1, %rax
	movq	%rax, -24(%rbp)
/*changes = t0*/
	movq	-24(%rbp), %rax
	movq	%rax, -16(%rbp)
/*e0: skip*/
e0:
/*if changes = 0 goto e1*/
	movq	-16(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e1
1:
/*t1 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*changes = t1*/
	movq	-32(%rbp), %rax
	movq	%rax, -16(%rbp)
/*t2 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*i = t2*/
	movq	-48(%rbp), %rax
	movq	%rax, -40(%rbp)
/*e2: skip*/
e2:
/*t3 = values[0]*/
	movq	16(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -56(%rbp)
/*t4 = 1*/
	movq	$1, %rax
	movq	%rax, -64(%rbp)
/*t5 = t3 - t4*/
	movq	-56(%rbp), %rax
	movq	-64(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*if i < t5 goto e3*/
	movq	-40(%rbp), %rax
	movq	-72(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e3
1:
/*t6 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e4*/
	jmp 	e4
/*e3: skip*/
e3:
/*t6 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e4: skip*/
e4:
/*if t6 = 0 goto e5*/
	movq	-80(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e5
1:
/*t7 = i * 8*/
	movq	-40(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*t7 = t7 + 8*/
	movq	-88(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*t8 = values[t7]*/
	movq	16(%rbp), %rax
	movq	-88(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -96(%rbp)
/*t9 = 1*/
	movq	$1, %rax
	movq	%rax, -104(%rbp)
/*t10 = i + t9*/
	movq	-40(%rbp), %rax
	movq	-104(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -112(%rbp)
/*t11 = t10 * 8*/
	movq	-112(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t11 = t11 + 8*/
	movq	-120(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t12 = values[t11]*/
	movq	16(%rbp), %rax
	movq	-120(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -128(%rbp)
/*if t8 > t12 goto e6*/
	movq	-96(%rbp), %rax
	movq	-128(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e6
1:
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -136(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t13 = -1*/
	movq	$-1, %rax
	movq	%rax, -136(%rbp)
/*e7: skip*/
e7:
/*if t13 = 0 goto e8*/
	movq	-136(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e8
1:
/*t14 = 1*/
	movq	$1, %rax
	movq	%rax, -144(%rbp)
/*t15 = i + t14*/
	movq	-40(%rbp), %rax
	movq	-144(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*param t15*/
	movq	-152(%rbp), %rax
	push	%rax
/*param i*/
	movq	-40(%rbp), %rax
	push	%rax
/*param values*/
	movq	16(%rbp), %rax
	push	%rax
/*call s1*/
	call	t_swap
/*t16 = -1*/
	movq	$-1, %rax
	movq	%rax, -160(%rbp)
/*changes = t16*/
	movq	-160(%rbp), %rax
	movq	%rax, -16(%rbp)
/*e8: skip*/
e8:
/*t17 = 1*/
	movq	$1, %rax
	movq	%rax, -168(%rbp)
/*i = i + t17*/
	movq	-40(%rbp), %rax
	movq	-168(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*goto e2*/
	jmp 	e2
/*e5: skip*/
e5:
/*goto e0*/
	jmp 	e0
/*e1: skip*/
e1:
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_swap: skip*/
t_swap:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$96, %rsp
/*t18 = i * 8*/
	movq	24(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t18 = t18 + 8*/
	movq	-40(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t19 = values[t18]*/
	movq	16(%rbp), %rax
	movq	-40(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*temp = t19*/
	movq	-48(%rbp), %rax
	movq	%rax, -32(%rbp)
/*t20 = values*/
	movq	16(%rbp), %rax
	movq	%rax, -56(%rbp)
/*t22 = j * 8*/
	movq	32(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t22 = t22 + 8*/
	movq	-72(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t23 = values[t22]*/
	movq	16(%rbp), %rax
	movq	-72(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -80(%rbp)
/*t21 = i * 8*/
	movq	24(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*t21 = t21 + 8*/
	movq	-64(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*t20[t21] = t23*/
	movq	-56(%rbp), %rcx
	movq	-64(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-80(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t24 = values*/
	movq	16(%rbp), %rax
	movq	%rax, -88(%rbp)
/*t25 = j * 8*/
	movq	32(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t25 = t25 + 8*/
	movq	-96(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t24[t25] = temp*/
	movq	-88(%rbp), %rcx
	movq	-96(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_printArray: skip*/
t_printArray:
/*pmb s2*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$48, %rsp
/*t26 = 0*/
	movq	$0, %rax
	movq	%rax, -16(%rbp)
/*t28 = values[0]*/
	movq	16(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -32(%rbp)
/*t29 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*value = t29*/
	movq	-48(%rbp), %rax
	movq	%rax, -40(%rbp)
/*e9: skip*/
e9:
/*if t26 = t28 goto e10*/
	movq	-16(%rbp), %rax
	movq	-32(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e10
1:
/*t27 = t26 * 8*/
	movq	-16(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*t27 = t27 + 8*/
	movq	-24(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*value = values[t27]*/
	movq	16(%rbp), %rax
	movq	-24(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -40(%rbp)
/*printInt(value)*/
	movq	-40(%rbp), %rdi
	call	print_uint64
/*t26 = t26 + 1*/
	movq	-16(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*goto e9*/
	jmp 	e9
/*e10: skip*/
e10:
/*rtn s2*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s3*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$96, %rsp
/*t30 = new array[10]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t30[0] = 10*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$10, %rbx
	movq	%rbx, (%rcx)
/*t31 = 8*/
	movq	$8, %rax
	movq	%rax, -24(%rbp)
/*t30[8] = t31*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t32 = 3*/
	movq	$3, %rax
	movq	%rax, -32(%rbp)
/*t30[16] = t32*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t33 = 4*/
	movq	$4, %rax
	movq	%rax, -40(%rbp)
/*t30[24] = t33*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t34 = 5*/
	movq	$5, %rax
	movq	%rax, -48(%rbp)
/*t30[32] = t34*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t35 = 7*/
	movq	$7, %rax
	movq	%rax, -56(%rbp)
/*t30[40] = t35*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t36 = 2*/
	movq	$2, %rax
	movq	%rax, -64(%rbp)
/*t30[48] = t36*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-64(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t37 = 0*/
	movq	$0, %rax
	movq	%rax, -72(%rbp)
/*t30[56] = t37*/
	movq	-16(%rbp), %rcx
	movq	$56, %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t38 = 6*/
	movq	$6, %rax
	movq	%rax, -80(%rbp)
/*t30[64] = t38*/
	movq	-16(%rbp), %rcx
	movq	$64, %rbx
	addq	%rbx, %rcx
	movq	-80(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t39 = 1*/
	movq	$1, %rax
	movq	%rax, -88(%rbp)
/*t30[72] = t39*/
	movq	-16(%rbp), %rcx
	movq	$72, %rbx
	addq	%rbx, %rcx
	movq	-88(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t40 = 9*/
	movq	$9, %rax
	movq	%rax, -96(%rbp)
/*t30[80] = t40*/
	movq	-16(%rbp), %rcx
	movq	$80, %rbx
	addq	%rbx, %rcx
	movq	-96(%rbp), %rbx
	movq	%rbx, (%rcx)
/*values = t30*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*param values*/
	movq	-8(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_bubbleSort
/*param values*/
	movq	-8(%rbp), %rax
	push	%rax
/*call s2*/
	call	t_printArray
/*rtn s3*/
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
	arr_3: .fill 88, 1
