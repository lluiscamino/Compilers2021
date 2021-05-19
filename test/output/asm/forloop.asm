.section	__TEXT, __text
	.globl	_main
	.globl	print_uint64
	.globl	print_boolean
	.globl	print_string
	.globl	string_length
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

/**
 * Prints a boolean to stdout
 * Params:
 * - %rbx: Boolean value
 */
print_boolean:
	testl	%ebx, %ebx
	jnz 	.print_boolean_true
	movq	decl_1@GOTPCREL(%rip), %rsi
	jmp 	.print_boolean_end
	.print_boolean_true:
		movq	decl_0@GOTPCREL(%rip), %rsi
	.print_boolean_end:
		call 	print_string
		ret

/**
 * Prints a string to stdout
 * Params:
 * - %rsi: String address
 */
print_string:
	call	string_length
	mov 	$0x02000004, %rax
	mov 	$1, %rdi
	syscall
	ret

/**
 * Returns a string's length (saves to %rdx)
 * Params:
 * - %rsi: String address
 * https://stackoverflow.com/questions/60482733/how-to-traverse-a-string-in-assembly-until-i-reach-null-strlen-loop
 */
string_length:
	lea 	-1(%rsi), %rdx
	.Lloop:
		inc 	%rdx
		cmpb	$0, (%rdx)
		jne 	.Lloop
	sub 	%rsi, %rdx
	ret

_main:
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
/*t_main: skip*/t_main:
/*pmb s0*/	push	%rbp
	mov 	%rsp, %rbp
	subq	$32, %rsp
/*i = 0*/	movq	$0, %rax
	movq	%rax, -8(%rbp)
/*e0: skip*/e0:
/*if i < 30 goto e1*/	movq	-8(%rbp), %rax
	movq	$30, %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t2 = 0*/	movq	$0, %rax
	movq	%rax, -16(%rbp)
/*goto e2*/	jmp 	e2
/*e1: skip*/e1:
/*t2 = -1*/	movq	$-1, %rax
	movq	%rax, -16(%rbp)
/*e2: skip*/e2:
/*if t2 = 0 goto e3*/	movq	-16(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*t4 = i % 2*/	movq	-8(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	$2, %rbx
	idivq	%rbx
	movq	%rdx, -24(%rbp)
/*if t4 = 0 goto e4*/	movq	-24(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t6 = 0*/	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*goto e5*/	jmp 	e5
/*e4: skip*/e4:
/*t6 = -1*/	movq	$-1, %rax
	movq	%rax, -32(%rbp)
/*e5: skip*/e5:
/*if t6 = 0 goto e6*/	movq	-32(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*printInt(i)*/	movq	-8(%rbp), %rdi
	call	print_uint64
/*e6: skip*/e6:
/*i = i + 1*/	movq	-8(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -8(%rbp)
/*goto e0*/	jmp 	e0
/*e3: skip*/e3:
/*rtn s0*/	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
