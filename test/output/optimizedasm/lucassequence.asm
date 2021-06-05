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
/*t_lucas: skip*/
t_lucas:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$56, %rsp
/*num1 = 2*/
	movq	$2, %rax
	movq	%rax, -16(%rbp)
/*num2 = 1*/
	movq	$1, %rax
	movq	%rax, -24(%rbp)
/*counter = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*e0: skip*/
e0:
/*if counter < N goto e1*/
	movq	-32(%rbp), %rax
	movq	16(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t3 = 0*/
	movq	$0, %rax
	movq	%rax, -40(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t3 = -1*/
	movq	$-1, %rax
	movq	%rax, -40(%rbp)
/*e2: skip*/
e2:
/*if t3 = 0 goto e3*/
	movq	-40(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*printInt(num1)*/
	movq	-16(%rbp), %rdi
	call	print_uint64
/*t4 = num2 + num1*/
	movq	-24(%rbp), %rax
	movq	-16(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*tmp = t4*/
	movq	-56(%rbp), %rax
	movq	%rax, -48(%rbp)
/*num1 = num2*/
	movq	-24(%rbp), %rax
	movq	%rax, -16(%rbp)
/*num2 = tmp*/
	movq	-48(%rbp), %rax
	movq	%rax, -24(%rbp)
/*counter = counter + 1*/
	movq	-32(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*param 25*/
	movq	$25, %rax
	push	%rax
/*call s0*/
	call	t_lucas
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
