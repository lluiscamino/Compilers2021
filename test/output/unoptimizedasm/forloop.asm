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
	subq	$72, %rsp
/*t0 = 0*/
	movq	$0, %rax
	movq	%rax, -16(%rbp)
/*i = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*e0: skip*/
e0:
/*t1 = 30*/
	movq	$30, %rax
	movq	%rax, -24(%rbp)
/*if i < t1 goto e1*/
	movq	-8(%rbp), %rax
	movq	-24(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t2 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t2 = -1*/
	movq	$-1, %rax
	movq	%rax, -32(%rbp)
/*e2: skip*/
e2:
/*if t2 = 0 goto e3*/
	movq	-32(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*t3 = 2*/
	movq	$2, %rax
	movq	%rax, -40(%rbp)
/*t4 = i % t3*/
	movq	-8(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	-40(%rbp), %rbx
	idivq	%rbx
	movq	%rdx, -48(%rbp)
/*t5 = 0*/
	movq	$0, %rax
	movq	%rax, -56(%rbp)
/*if t4 = t5 goto e4*/
	movq	-48(%rbp), %rax
	movq	-56(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t6 = 0*/
	movq	$0, %rax
	movq	%rax, -64(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t6 = -1*/
	movq	$-1, %rax
	movq	%rax, -64(%rbp)
/*e5: skip*/
e5:
/*if t6 = 0 goto e6*/
	movq	-64(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*printInt(i)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*e6: skip*/
e6:
/*t7 = 1*/
	movq	$1, %rax
	movq	%rax, -72(%rbp)
/*i = i + t7*/
	movq	-8(%rbp), %rax
	movq	-72(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -8(%rbp)
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
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
