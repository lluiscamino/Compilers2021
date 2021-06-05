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
	subq	$144, %rsp
/*t0 = 100*/
	movq	$100, %rax
	movq	%rax, -16(%rbp)
/*t2 = t0 * 8*/
	movq	-16(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t2 = t2 + 8*/
	movq	-32(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t1 = new array[t2]*/
	movq	%rsp, %rbx
	and 	$-16, %rsp
	movq	-32(%rbp), %rdi
	call	_malloc
	movq	%rbx, %rsp
	movq	%rax, -24(%rbp)
/*t1[0] = t0*/
	movq	-24(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	-16(%rbp), %rbx
	movq	%rbx, (%rcx)
/*arr = t1*/
	movq	-24(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t3 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*sum = t3*/
	movq	-48(%rbp), %rax
	movq	%rax, -40(%rbp)
/*t4 = 0*/
	movq	$0, %rax
	movq	%rax, -64(%rbp)
/*i = t4*/
	movq	-64(%rbp), %rax
	movq	%rax, -56(%rbp)
/*e0: skip*/
e0:
/*t5 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -72(%rbp)
/*if i < t5 goto e1*/
	movq	-56(%rbp), %rax
	movq	-72(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t6 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t6 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e2: skip*/
e2:
/*if t6 = 0 goto e3*/
	movq	-80(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*t7 = arr*/
	movq	-8(%rbp), %rax
	movq	%rax, -88(%rbp)
/*t8 = i * 8*/
	movq	-56(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t8 = t8 + 8*/
	movq	-96(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t7[t8] = i*/
	movq	-88(%rbp), %rcx
	movq	-96(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t9 = 1*/
	movq	$1, %rax
	movq	%rax, -104(%rbp)
/*i = i + t9*/
	movq	-56(%rbp), %rax
	movq	-104(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*t10 = 0*/
	movq	$0, %rax
	movq	%rax, -112(%rbp)
/*t12 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -128(%rbp)
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -144(%rbp)
/*el = t13*/
	movq	-144(%rbp), %rax
	movq	%rax, -136(%rbp)
/*e4: skip*/
e4:
/*if t10 = t12 goto e5*/
	movq	-112(%rbp), %rax
	movq	-128(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e5
1:
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
/*el = arr[t11]*/
	movq	-8(%rbp), %rax
	movq	-120(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -136(%rbp)
/*sum = sum + el*/
	movq	-40(%rbp), %rax
	movq	-136(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t10 = t10 + 1*/
	movq	-112(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -112(%rbp)
/*goto e4*/
	jmp 	e4
/*e5: skip*/
e5:
/*printInt(sum)*/
	movq	-40(%rbp), %rdi
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
