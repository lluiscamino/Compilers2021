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
	subq	$248, %rsp
/*t0 = new array[16]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 16*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$16, %rbx
	movq	%rbx, (%rcx)
/*t1 = 1*/
	movq	$1, %rax
	movq	%rax, -24(%rbp)
/*t0[8] = t1*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t2 = 2*/
	movq	$2, %rax
	movq	%rax, -32(%rbp)
/*t0[16] = t2*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t3 = 3*/
	movq	$3, %rax
	movq	%rax, -40(%rbp)
/*t0[24] = t3*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t4 = 4*/
	movq	$4, %rax
	movq	%rax, -48(%rbp)
/*t0[32] = t4*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t5 = 5*/
	movq	$5, %rax
	movq	%rax, -56(%rbp)
/*t0[40] = t5*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t6 = 6*/
	movq	$6, %rax
	movq	%rax, -64(%rbp)
/*t0[48] = t6*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-64(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t7 = 7*/
	movq	$7, %rax
	movq	%rax, -72(%rbp)
/*t0[56] = t7*/
	movq	-16(%rbp), %rcx
	movq	$56, %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t8 = 8*/
	movq	$8, %rax
	movq	%rax, -80(%rbp)
/*t0[64] = t8*/
	movq	-16(%rbp), %rcx
	movq	$64, %rbx
	addq	%rbx, %rcx
	movq	-80(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t9 = 1*/
	movq	$1, %rax
	movq	%rax, -88(%rbp)
/*t10 = - t9*/
	xorq 	%rax, %rax
	movq	-88(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t0[72] = t10*/
	movq	-16(%rbp), %rcx
	movq	$72, %rbx
	addq	%rbx, %rcx
	movq	-96(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t11 = 2*/
	movq	$2, %rax
	movq	%rax, -104(%rbp)
/*t12 = - t11*/
	xorq 	%rax, %rax
	movq	-104(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -112(%rbp)
/*t0[80] = t12*/
	movq	-16(%rbp), %rcx
	movq	$80, %rbx
	addq	%rbx, %rcx
	movq	-112(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t13 = 3*/
	movq	$3, %rax
	movq	%rax, -120(%rbp)
/*t14 = - t13*/
	xorq 	%rax, %rax
	movq	-120(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*t0[88] = t14*/
	movq	-16(%rbp), %rcx
	movq	$88, %rbx
	addq	%rbx, %rcx
	movq	-128(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t15 = 4*/
	movq	$4, %rax
	movq	%rax, -136(%rbp)
/*t16 = - t15*/
	xorq 	%rax, %rax
	movq	-136(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -144(%rbp)
/*t0[96] = t16*/
	movq	-16(%rbp), %rcx
	movq	$96, %rbx
	addq	%rbx, %rcx
	movq	-144(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t17 = 5*/
	movq	$5, %rax
	movq	%rax, -152(%rbp)
/*t18 = - t17*/
	xorq 	%rax, %rax
	movq	-152(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -160(%rbp)
/*t0[104] = t18*/
	movq	-16(%rbp), %rcx
	movq	$104, %rbx
	addq	%rbx, %rcx
	movq	-160(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t19 = 6*/
	movq	$6, %rax
	movq	%rax, -168(%rbp)
/*t20 = - t19*/
	xorq 	%rax, %rax
	movq	-168(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -176(%rbp)
/*t0[112] = t20*/
	movq	-16(%rbp), %rcx
	movq	$112, %rbx
	addq	%rbx, %rcx
	movq	-176(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t21 = 7*/
	movq	$7, %rax
	movq	%rax, -184(%rbp)
/*t22 = - t21*/
	xorq 	%rax, %rax
	movq	-184(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -192(%rbp)
/*t0[120] = t22*/
	movq	-16(%rbp), %rcx
	movq	$120, %rbx
	addq	%rbx, %rcx
	movq	-192(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t23 = 8*/
	movq	$8, %rax
	movq	%rax, -200(%rbp)
/*t24 = - t23*/
	xorq 	%rax, %rax
	movq	-200(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -208(%rbp)
/*t0[128] = t24*/
	movq	-16(%rbp), %rcx
	movq	$128, %rbx
	addq	%rbx, %rcx
	movq	-208(%rbp), %rbx
	movq	%rbx, (%rcx)
/*arr = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t25 = 0*/
	movq	$0, %rax
	movq	%rax, -216(%rbp)
/*t27 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -232(%rbp)
/*t28 = 0*/
	movq	$0, %rax
	movq	%rax, -248(%rbp)
/*el = t28*/
	movq	-248(%rbp), %rax
	movq	%rax, -240(%rbp)
/*e0: skip*/
e0:
/*if t25 = t27 goto e1*/
	movq	-216(%rbp), %rax
	movq	-232(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e1
1:
/*t26 = t25 * 8*/
	movq	-216(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -224(%rbp)
/*t26 = t26 + 8*/
	movq	-224(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -224(%rbp)
/*el = arr[t26]*/
	movq	-8(%rbp), %rax
	movq	-224(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -240(%rbp)
/*printInt(el)*/
	movq	-240(%rbp), %rdi
	call	print_uint64
/*t25 = t25 + 1*/
	movq	-216(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -216(%rbp)
/*goto e0*/
	jmp 	e0
/*e1: skip*/
e1:
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
	arr_3: .fill 136, 1
