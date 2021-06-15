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
	subq	$120, %rsp
/*t0 = new array[3]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -8(%rbp)
/*t0[0] = 3*/
	movq	-8(%rbp), %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = 3*/
	movq	-8(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = 2*/
	movq	-8(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t0[24] = -7*/
	movq	-8(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$-7, %rbx
	movq	%rbx, (%rcx)
/*t5 = t0[0]*/
	movq	-8(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -16(%rbp)
/*printInt(t5)*/
	movq	-16(%rbp), %rdi
	call	print_uint64
/*t6 = new array[4]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -32(%rbp)
/*t6[0] = 4*/
	movq	-32(%rbp), %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t6[8] = 3*/
	movq	-32(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t6[16] = 4*/
	movq	-32(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t6[24] = 5*/
	movq	-32(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t6[32] = -6*/
	movq	-32(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$-6, %rbx
	movq	%rbx, (%rcx)
/*arr = t6*/
	movq	-32(%rbp), %rax
	movq	%rax, -24(%rbp)
/*t12 = t6[0]*/
	movq	-32(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -40(%rbp)
/*printInt(t12)*/
	movq	-40(%rbp), %rdi
	call	print_uint64
/*t13 = t6[0]*/
	movq	-32(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*t14 = new array[2]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -56(%rbp)
/*t14[0] = 2*/
	movq	-56(%rbp), %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t14[8] = 3*/
	movq	-56(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t14[16] = 2*/
	movq	-56(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t17 = t14[0]*/
	movq	-56(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -64(%rbp)
/*t18 = t13 + t17*/
	movq	-48(%rbp), %rax
	movq	-64(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t19 = new array[3]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -80(%rbp)
/*t19[0] = 3*/
	movq	-80(%rbp), %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t19[8] = -8*/
	movq	-80(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$-8, %rbx
	movq	%rbx, (%rcx)
/*t19[16] = 9*/
	movq	-80(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t19[24] = 48*/
	movq	-80(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$48, %rbx
	movq	%rbx, (%rcx)
/*t26 = t19[0]*/
	movq	-80(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -88(%rbp)
/*t27 = t18 + t26*/
	movq	-72(%rbp), %rax
	movq	-88(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t28 = new array[1]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -104(%rbp)
/*t28[0] = 1*/
	movq	-104(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t28[8] = 1*/
	movq	-104(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t30 = t28[0]*/
	movq	-104(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -112(%rbp)
/*t31 = t27 + t30*/
	movq	-96(%rbp), %rax
	movq	-112(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*printInt(t31)*/
	movq	-120(%rbp), %rdi
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
	arr_3: .fill 32, 1
	arr_4: .fill 40, 1
	arr_5: .fill 24, 1
	arr_6: .fill 32, 1
	arr_7: .fill 16, 1
