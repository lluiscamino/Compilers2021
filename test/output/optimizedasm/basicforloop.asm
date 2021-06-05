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
	subq	$49, %rsp
/*t0 = new array[4]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 4*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = 65*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$65, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = 93*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$93, %rbx
	movq	%rbx, (%rcx)
/*t0[24] = 28*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$28, %rbx
	movq	%rbx, (%rcx)
/*t0[32] = 92*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$92, %rbx
	movq	%rbx, (%rcx)
/*arr = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*i = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*e0: skip*/
e0:
/*t14 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -32(%rbp)
/*if i < t14 goto e1*/
	movq	-24(%rbp), %rax
	movq	-32(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t15 = 0*/
	movb	$0, %al
	movb	%al, -33(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t15 = -1*/
	movb	$-1, %al
	movb	%al, -33(%rbp)
/*e2: skip*/
e2:
/*if t15 = 0 goto e3*/
	movb	-33(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e3
1:
/*t16 = i * 8*/
	movq	-24(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -41(%rbp)
/*t16 = t16 + 8*/
	movq	-41(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -41(%rbp)
/*t17 = arr[t16]*/
	movq	-8(%rbp), %rax
	movq	-41(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -49(%rbp)
/*printInt(t17)*/
	movq	-49(%rbp), %rdi
	call	print_uint64
/*i = i + 1*/
	movq	-24(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
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
	arr_3: .fill 40, 1
