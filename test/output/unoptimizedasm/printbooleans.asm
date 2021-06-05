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
/*t_printNot: skip*/
t_printNot:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$9, %rsp
/*t0 = not value*/
	movb	16(%rbp), %bl
	notb	%bl
	movb	%bl, -9(%rbp)
/*printBoolean(t0)*/
	movb	-9(%rbp), %bl
	call	print_boolean
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$119, %rsp
/*t1 = -1*/
	movb	$-1, %al
	movb	%al, -1(%rbp)
/*printBoolean(t1)*/
	movb	-1(%rbp), %bl
	call	print_boolean
/*t2 = 0*/
	movb	$0, %al
	movb	%al, -2(%rbp)
/*printBoolean(t2)*/
	movb	-2(%rbp), %bl
	call	print_boolean
/*t3 = -1*/
	movb	$-1, %al
	movb	%al, -3(%rbp)
/*param t3*/
	movq	-3(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printNot
/*t4 = 0*/
	movb	$0, %al
	movb	%al, -4(%rbp)
/*param t4*/
	movq	-4(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printNot
/*t5 = -1*/
	movb	$-1, %al
	movb	%al, -5(%rbp)
/*t6 = 0*/
	movb	$0, %al
	movb	%al, -6(%rbp)
/*t7 = t5 and t6*/
	movb	-5(%rbp), %al
	movb	-6(%rbp), %bl
	andb	%bl, %al
	movb	%al, -7(%rbp)
/*printBoolean(t7)*/
	movb	-7(%rbp), %bl
	call	print_boolean
/*t8 = -1*/
	movb	$-1, %al
	movb	%al, -8(%rbp)
/*t9 = 0*/
	movb	$0, %al
	movb	%al, -9(%rbp)
/*t10 = t8 or t9*/
	movb	-8(%rbp), %al
	movb	-9(%rbp), %bl
	orb 	%bl, %al
	movb	%al, -10(%rbp)
/*printBoolean(t10)*/
	movb	-10(%rbp), %bl
	call	print_boolean
/*t11 = 3*/
	movq	$3, %rax
	movq	%rax, -18(%rbp)
/*t12 = 5*/
	movq	$5, %rax
	movq	%rax, -26(%rbp)
/*if t11 > t12 goto e0*/
	movq	-18(%rbp), %rax
	movq	-26(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t13 = 0*/
	movb	$0, %al
	movb	%al, -27(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t13 = -1*/
	movb	$-1, %al
	movb	%al, -27(%rbp)
/*e1: skip*/
e1:
/*t14 = 7*/
	movq	$7, %rax
	movq	%rax, -35(%rbp)
/*t15 = 9*/
	movq	$9, %rax
	movq	%rax, -43(%rbp)
/*if t14 < t15 goto e2*/
	movq	-35(%rbp), %rax
	movq	-43(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e2
1:
/*t16 = 0*/
	movb	$0, %al
	movb	%al, -44(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t16 = -1*/
	movb	$-1, %al
	movb	%al, -44(%rbp)
/*e3: skip*/
e3:
/*t17 = t13 or t16*/
	movb	-27(%rbp), %al
	movb	-44(%rbp), %bl
	orb 	%bl, %al
	movb	%al, -45(%rbp)
/*printBoolean(t17)*/
	movb	-45(%rbp), %bl
	call	print_boolean
/*t18 = -1*/
	movb	$-1, %al
	movb	%al, -46(%rbp)
/*t19 = not t18*/
	movb	-46(%rbp), %bl
	notb	%bl
	movb	%bl, -47(%rbp)
/*t20 = 0*/
	movb	$0, %al
	movb	%al, -48(%rbp)
/*t21 = not t20*/
	movb	-48(%rbp), %bl
	notb	%bl
	movb	%bl, -49(%rbp)
/*t22 = t19 or t21*/
	movb	-47(%rbp), %al
	movb	-49(%rbp), %bl
	orb 	%bl, %al
	movb	%al, -50(%rbp)
/*printBoolean(t22)*/
	movb	-50(%rbp), %bl
	call	print_boolean
/*t23 = 3*/
	movq	$3, %rax
	movq	%rax, -58(%rbp)
/*t24 = 3*/
	movq	$3, %rax
	movq	%rax, -66(%rbp)
/*if t23 = t24 goto e4*/
	movq	-58(%rbp), %rax
	movq	-66(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t25 = 0*/
	movb	$0, %al
	movb	%al, -67(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t25 = -1*/
	movb	$-1, %al
	movb	%al, -67(%rbp)
/*e5: skip*/
e5:
/*printBoolean(t25)*/
	movb	-67(%rbp), %bl
	call	print_boolean
/*t26 = 3*/
	movq	$3, %rax
	movq	%rax, -75(%rbp)
/*t27 = 6*/
	movq	$6, %rax
	movq	%rax, -83(%rbp)
/*if t26 = t27 goto e6*/
	movq	-75(%rbp), %rax
	movq	-83(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*t28 = 0*/
	movb	$0, %al
	movb	%al, -84(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t28 = -1*/
	movb	$-1, %al
	movb	%al, -84(%rbp)
/*e7: skip*/
e7:
/*printBoolean(t28)*/
	movb	-84(%rbp), %bl
	call	print_boolean
/*t29 = 3*/
	movq	$3, %rax
	movq	%rax, -92(%rbp)
/*t30 = 5*/
	movq	$5, %rax
	movq	%rax, -100(%rbp)
/*if t29 != t30 goto e8*/
	movq	-92(%rbp), %rax
	movq	-100(%rbp), %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e8
1:
/*t31 = 0*/
	movb	$0, %al
	movb	%al, -101(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t31 = -1*/
	movb	$-1, %al
	movb	%al, -101(%rbp)
/*e9: skip*/
e9:
/*t32 = 4*/
	movq	$4, %rax
	movq	%rax, -109(%rbp)
/*t33 = 6*/
	movq	$6, %rax
	movq	%rax, -117(%rbp)
/*if t32 != t33 goto e10*/
	movq	-109(%rbp), %rax
	movq	-117(%rbp), %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e10
1:
/*t34 = 0*/
	movb	$0, %al
	movb	%al, -118(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t34 = -1*/
	movb	$-1, %al
	movb	%al, -118(%rbp)
/*e11: skip*/
e11:
/*t35 = t31 or t34*/
	movb	-101(%rbp), %al
	movb	-118(%rbp), %bl
	orb 	%bl, %al
	movb	%al, -119(%rbp)
/*printBoolean(t35)*/
	movb	-119(%rbp), %bl
	call	print_boolean
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/**
 * Prints a boolean to stdout
 * Params:
 * - %bl: Boolean value
 */
print_boolean:
	testb	%bl, %bl
	jnz 	.print_boolean_true
	movq	decl_1@GOTPCREL(%rip), %rsi
	jmp 	.print_boolean_end
	.print_boolean_true:
		movq	decl_0@GOTPCREL(%rip), %rsi
	.print_boolean_end:
		call 	print_string
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
