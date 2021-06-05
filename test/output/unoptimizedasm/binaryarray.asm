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
	subq	$52, %rsp
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	%rbp, (%rsi)
/*t0 = 10*/
	movq	$10, %rax
	movq	%rax, -16(%rbp)
/*t2 = t0 * 1*/
	movq	-16(%rbp), %rax
	movq	$1, %rbx
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
/*arr1 = t1*/
	movq	-24(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t3 = new array[4]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -48(%rbp)
/*t3[0] = 4*/
	movq	-48(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t4 = -1*/
	movb	$-1, %al
	movb	%al, -49(%rbp)
/*t3[8] = t4*/
	movq	-48(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movb	-49(%rbp), %bl
	movb	%bl, (%rcx)
/*t5 = 0*/
	movb	$0, %al
	movb	%al, -50(%rbp)
/*t3[9] = t5*/
	movq	-48(%rbp), %rcx
	movq	$9, %rbx
	addq	%rbx, %rcx
	movb	-50(%rbp), %bl
	movb	%bl, (%rcx)
/*t6 = 0*/
	movb	$0, %al
	movb	%al, -51(%rbp)
/*t3[10] = t6*/
	movq	-48(%rbp), %rcx
	movq	$10, %rbx
	addq	%rbx, %rcx
	movb	-51(%rbp), %bl
	movb	%bl, (%rcx)
/*t7 = -1*/
	movb	$-1, %al
	movb	%al, -52(%rbp)
/*t3[11] = t7*/
	movq	-48(%rbp), %rcx
	movq	$11, %rbx
	addq	%rbx, %rcx
	movb	-52(%rbp), %bl
	movb	%bl, (%rcx)
/*arr2 = t3*/
	movq	-48(%rbp), %rax
	movq	%rax, -40(%rbp)
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
	subq	$134, %rsp
/*t8 = 0*/
	movq	$0, %rax
	movq	%rax, -16(%rbp)
/*i = t8*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*e0: skip*/
e0:
/*t9 = arr1[0]*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-8(%rsi), %rax

	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -24(%rbp)
/*if i < t9 goto e1*/
	movq	-8(%rbp), %rax
	movq	-24(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t10 = 0*/
	movb	$0, %al
	movb	%al, -25(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t10 = -1*/
	movb	$-1, %al
	movb	%al, -25(%rbp)
/*e2: skip*/
e2:
/*if t10 = 0 goto e3*/
	movb	-25(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e3
1:
/*t11 = arr1*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-8(%rsi), %rax

	movq	%rax, -33(%rbp)
/*t13 = 2*/
	movq	$2, %rax
	movq	%rax, -49(%rbp)
/*t14 = i % t13*/
	movq	-8(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	-49(%rbp), %rbx
	idivq	%rbx
	movq	%rdx, -57(%rbp)
/*t15 = 0*/
	movq	$0, %rax
	movq	%rax, -65(%rbp)
/*if t14 = t15 goto e4*/
	movq	-57(%rbp), %rax
	movq	-65(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t16 = 0*/
	movb	$0, %al
	movb	%al, -66(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t16 = -1*/
	movb	$-1, %al
	movb	%al, -66(%rbp)
/*e5: skip*/
e5:
/*t12 = i * 1*/
	movq	-8(%rbp), %rax
	movq	$1, %rbx
	imulq	%rbx, %rax
	movq	%rax, -41(%rbp)
/*t12 = t12 + 8*/
	movq	-41(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -41(%rbp)
/*t11[t12] = t16*/
	movq	-33(%rbp), %rcx
	movq	-41(%rbp), %rbx
	addq	%rbx, %rcx
	movb	-66(%rbp), %bl
	movb	%bl, (%rcx)
/*t17 = 1*/
	movq	$1, %rax
	movq	%rax, -74(%rbp)
/*i = i + t17*/
	movq	-8(%rbp), %rax
	movq	-74(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -8(%rbp)
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*t18 = 0*/
	movq	$0, %rax
	movq	%rax, -82(%rbp)
/*t20 = arr1[0]*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-8(%rsi), %rax

	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -98(%rbp)
/*t21 = 0*/
	movb	$0, %al
	movb	%al, -100(%rbp)
/*el = t21*/
	movb	-100(%rbp), %al
	movb	%al, -99(%rbp)
/*e6: skip*/
e6:
/*if t18 = t20 goto e7*/
	movq	-82(%rbp), %rax
	movq	-98(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e7
1:
/*t19 = t18 * 1*/
	movq	-82(%rbp), %rax
	movq	$1, %rbx
	imulq	%rbx, %rax
	movq	%rax, -90(%rbp)
/*t19 = t19 + 8*/
	movq	-90(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -90(%rbp)
/*el = arr1[t19]*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-8(%rsi), %rax

	movq	-90(%rbp), %rbx
	addq	%rbx, %rax
	movb	(%rax), %al
	movb	%al, -99(%rbp)
/*printBoolean(el)*/
	movb	-99(%rbp), %bl
	call	print_boolean
/*t18 = t18 + 1*/
	movq	-82(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -82(%rbp)
/*goto e6*/
	jmp 	e6
/*e7: skip*/
e7:
/*t22 = "\n"*/
	movq	str_4@GOTPCREL(%rip), %rax
	movq	%rax, -108(%rbp)
/*printString(t22)*/
	movq	-108(%rbp), %rsi
	call	print_string
/*t23 = 0*/
	movq	$0, %rax
	movq	%rax, -116(%rbp)
/*t25 = arr2[0]*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-40(%rsi), %rax

	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -132(%rbp)
/*t26 = 0*/
	movb	$0, %al
	movb	%al, -134(%rbp)
/*el = t26*/
	movb	-134(%rbp), %al
	movb	%al, -133(%rbp)
/*e8: skip*/
e8:
/*if t23 = t25 goto e9*/
	movq	-116(%rbp), %rax
	movq	-132(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e9
1:
/*t24 = t23 * 1*/
	movq	-116(%rbp), %rax
	movq	$1, %rbx
	imulq	%rbx, %rax
	movq	%rax, -124(%rbp)
/*t24 = t24 + 8*/
	movq	-124(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -124(%rbp)
/*el = arr2[t24]*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-40(%rsi), %rax

	movq	-124(%rbp), %rbx
	addq	%rbx, %rax
	movb	(%rax), %al
	movb	%al, -133(%rbp)
/*printBoolean(el)*/
	movb	-133(%rbp), %bl
	call	print_boolean
/*t23 = t23 + 1*/
	movq	-116(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -116(%rbp)
/*goto e8*/
	jmp 	e8
/*e9: skip*/
e9:
/*rtn s0*/
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
	arr_3: .fill 12, 1
	str_4: .asciz "\n"
