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
/*t_main: skip*/
t_main:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$264, %rsp
/*t0 = new array[4]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -8(%rbp)
/*t0[0] = 3*/
	movq	-8(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t1 = 3*/
	movq	$3, %rax
	movq	%rax, -16(%rbp)
/*t0[8] = t1*/
	movq	-8(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-16(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t2 = 2*/
	movq	$2, %rax
	movq	%rax, -24(%rbp)
/*t0[16] = t2*/
	movq	-8(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t3 = 7*/
	movq	$7, %rax
	movq	%rax, -32(%rbp)
/*t4 = - t3*/
	xorq 	%rax, %rax
	movq	-32(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t0[24] = t4*/
	movq	-8(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t5 = t0[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*printInt(t5)*/
	movq	-48(%rbp), %rdi
	call	print_uint64
/*t6 = new array[5]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -64(%rbp)
/*t6[0] = 4*/
	movq	-64(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t7 = 3*/
	movq	$3, %rax
	movq	%rax, -72(%rbp)
/*t6[8] = t7*/
	movq	-64(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t8 = 4*/
	movq	$4, %rax
	movq	%rax, -80(%rbp)
/*t6[16] = t8*/
	movq	-64(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-80(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t9 = 5*/
	movq	$5, %rax
	movq	%rax, -88(%rbp)
/*t6[24] = t9*/
	movq	-64(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-88(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t10 = 6*/
	movq	$6, %rax
	movq	%rax, -96(%rbp)
/*t11 = - t10*/
	xorq 	%rax, %rax
	movq	-96(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -104(%rbp)
/*t6[32] = t11*/
	movq	-64(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-104(%rbp), %rbx
	movq	%rbx, (%rcx)
/*arr = t6*/
	movq	-64(%rbp), %rax
	movq	%rax, -56(%rbp)
/*t12 = arr[0]*/
	movq	-56(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -112(%rbp)
/*printInt(t12)*/
	movq	-112(%rbp), %rdi
	call	print_uint64
/*t13 = arr[0]*/
	movq	-56(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -120(%rbp)
/*t14 = new array[3]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -128(%rbp)
/*t14[0] = 2*/
	movq	-128(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t15 = 3*/
	movq	$3, %rax
	movq	%rax, -136(%rbp)
/*t14[8] = t15*/
	movq	-128(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-136(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t16 = 2*/
	movq	$2, %rax
	movq	%rax, -144(%rbp)
/*t14[16] = t16*/
	movq	-128(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-144(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t17 = t14[0]*/
	movq	-128(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -152(%rbp)
/*t18 = t13 + t17*/
	movq	-120(%rbp), %rax
	movq	-152(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -160(%rbp)
/*t19 = new array[4]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -168(%rbp)
/*t19[0] = 3*/
	movq	-168(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t20 = 8*/
	movq	$8, %rax
	movq	%rax, -176(%rbp)
/*t21 = - t20*/
	xorq 	%rax, %rax
	movq	-176(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -184(%rbp)
/*t19[8] = t21*/
	movq	-168(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-184(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t22 = 9*/
	movq	$9, %rax
	movq	%rax, -192(%rbp)
/*t19[16] = t22*/
	movq	-168(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-192(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t23 = 45*/
	movq	$45, %rax
	movq	%rax, -200(%rbp)
/*t24 = 3*/
	movq	$3, %rax
	movq	%rax, -208(%rbp)
/*t25 = t23 + t24*/
	movq	-200(%rbp), %rax
	movq	-208(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -216(%rbp)
/*t19[24] = t25*/
	movq	-168(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-216(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t26 = t19[0]*/
	movq	-168(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -224(%rbp)
/*t27 = t18 + t26*/
	movq	-160(%rbp), %rax
	movq	-224(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -232(%rbp)
/*t28 = new array[2]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -240(%rbp)
/*t28[0] = 1*/
	movq	-240(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t29 = 1*/
	movq	$1, %rax
	movq	%rax, -248(%rbp)
/*t28[8] = t29*/
	movq	-240(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-248(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t30 = t28[0]*/
	movq	-240(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -256(%rbp)
/*t31 = t27 + t30*/
	movq	-232(%rbp), %rax
	movq	-256(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -264(%rbp)
/*printInt(t31)*/
	movq	-264(%rbp), %rdi
	call	print_uint64
/*rtn s0*/
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
	arr_3: .fill 4, 8
	arr_4: .fill 5, 8
	arr_5: .fill 3, 8
	arr_6: .fill 4, 8
	arr_7: .fill 2, 8
