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
	subq	$48, %rsp
/*t0 = new array[16]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 16*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = 1*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = 2*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t0[24] = 3*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[32] = 4*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t0[40] = 5*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t0[48] = 6*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t0[56] = 7*/
	movq	-16(%rbp), %rcx
	movq	$56, %rbx
	addq	%rbx, %rcx
	movq	$7, %rbx
	movq	%rbx, (%rcx)
/*t0[64] = 8*/
	movq	-16(%rbp), %rcx
	movq	$64, %rbx
	addq	%rbx, %rcx
	movq	$8, %rbx
	movq	%rbx, (%rcx)
/*t0[72] = -1*/
	movq	-16(%rbp), %rcx
	movq	$72, %rbx
	addq	%rbx, %rcx
	movq	$-1, %rbx
	movq	%rbx, (%rcx)
/*t0[80] = -2*/
	movq	-16(%rbp), %rcx
	movq	$80, %rbx
	addq	%rbx, %rcx
	movq	$-2, %rbx
	movq	%rbx, (%rcx)
/*t0[88] = -3*/
	movq	-16(%rbp), %rcx
	movq	$88, %rbx
	addq	%rbx, %rcx
	movq	$-3, %rbx
	movq	%rbx, (%rcx)
/*t0[96] = -4*/
	movq	-16(%rbp), %rcx
	movq	$96, %rbx
	addq	%rbx, %rcx
	movq	$-4, %rbx
	movq	%rbx, (%rcx)
/*t0[104] = -5*/
	movq	-16(%rbp), %rcx
	movq	$104, %rbx
	addq	%rbx, %rcx
	movq	$-5, %rbx
	movq	%rbx, (%rcx)
/*t0[112] = -6*/
	movq	-16(%rbp), %rcx
	movq	$112, %rbx
	addq	%rbx, %rcx
	movq	$-6, %rbx
	movq	%rbx, (%rcx)
/*t0[120] = -7*/
	movq	-16(%rbp), %rcx
	movq	$120, %rbx
	addq	%rbx, %rcx
	movq	$-7, %rbx
	movq	%rbx, (%rcx)
/*t0[128] = -8*/
	movq	-16(%rbp), %rcx
	movq	$128, %rbx
	addq	%rbx, %rcx
	movq	$-8, %rbx
	movq	%rbx, (%rcx)
/*arr = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t25 = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*t27 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -40(%rbp)
/*el = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*e0: skip*/
e0:
/*if t25 = t27 goto e1*/
	movq	-24(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e1
1:
/*t26 = t25 * 8*/
	movq	-24(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t26 = t26 + 8*/
	movq	-32(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*el = arr[t26]*/
	movq	-8(%rbp), %rax
	movq	-32(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*printInt(el)*/
	movq	-48(%rbp), %rdi
	call	print_uint64
/*t25 = t25 + 1*/
	movq	-24(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
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
