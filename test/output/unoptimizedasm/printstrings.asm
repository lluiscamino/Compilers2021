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
/*t_printString: skip*/
t_printString:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*printString(str)*/
	movq	16(%rbp), %rsi
	call	print_string
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$56, %rsp
/*t0 = "Hi! 😀\n"*/
	movq	str_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*constString = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t1 = "Hola\n"*/
	movq	str_4@GOTPCREL(%rip), %rax
	movq	%rax, -32(%rbp)
/*varString = t1*/
	movq	-32(%rbp), %rax
	movq	%rax, -24(%rbp)
/*t2 = "Hello, world\n"*/
	movq	str_5@GOTPCREL(%rip), %rax
	movq	%rax, -40(%rbp)
/*printString(t2)*/
	movq	-40(%rbp), %rsi
	call	print_string
/*printString(constString)*/
	movq	-8(%rbp), %rsi
	call	print_string
/*printString(varString)*/
	movq	-24(%rbp), %rsi
	call	print_string
/*t3 = "Adios\n"*/
	movq	str_6@GOTPCREL(%rip), %rax
	movq	%rax, -48(%rbp)
/*varString = t3*/
	movq	-48(%rbp), %rax
	movq	%rax, -24(%rbp)
/*printString(varString)*/
	movq	-24(%rbp), %rsi
	call	print_string
/*t4 = "749\n"*/
	movq	str_7@GOTPCREL(%rip), %rax
	movq	%rax, -56(%rbp)
/*param t4*/
	movq	-56(%rbp), %rax
	pushq	%rax
/*call s0*/
	call	t_printString
/*param constString*/
	movq	-8(%rbp), %rax
	pushq	%rax
/*call s0*/
	call	t_printString
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
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

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	str_3: .asciz "Hi! 😀\n"
	str_4: .asciz "Hola\n"
	str_5: .asciz "Hello, world\n"
	str_6: .asciz "Adios\n"
	str_7: .asciz "749\n"
