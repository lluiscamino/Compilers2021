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
/*t_main: skip*/
t_main:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$32, %rsp
/*t1 = stringLength("Hello\n")*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	call	string_length
	subq	$1, %rdx
	movq	%rdx, -8(%rbp)
/*printInt(t1)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*t3 = stringLength("Hello, world!\n")*/
	movq	decl_3@GOTPCREL(%rip), %rsi
	call	string_length
	subq	$1, %rdx
	movq	%rdx, -16(%rbp)
/*printInt(t3)*/
	movq	-16(%rbp), %rdi
	call	print_uint64
/*t5 = stringLength("\n")*/
	movq	decl_4@GOTPCREL(%rip), %rsi
	call	string_length
	subq	$1, %rdx
	movq	%rdx, -24(%rbp)
/*printInt(t5)*/
	movq	-24(%rbp), %rdi
	call	print_uint64
/*t7 = stringLength("-1\n")*/
	movq	decl_5@GOTPCREL(%rip), %rsi
	call	string_length
	subq	$1, %rdx
	movq	%rdx, -32(%rbp)
/*printInt(t7)*/
	movq	-32(%rbp), %rdi
	call	print_uint64
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .asciz "Hello\n"
	decl_3: .asciz "Hello, world!\n"
	decl_4: .asciz "\n"
	decl_5: .asciz "-1\n"
