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
	subq	$138, %rsp
/*t0 = "Hello\n"*/
	movq	str_3@GOTPCREL(%rip), %rax
	movq	%rax, -8(%rbp)
/*t1 = "Hello\n"*/
	movq	str_4@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*if t0 = t1 goto e0*/
	movq	-8(%rbp), %rsi
	movq	-16(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	je  	e0
/*t2 = 0*/
	movb	$0, %al
	movb	%al, -17(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t2 = -1*/
	movb	$-1, %al
	movb	%al, -17(%rbp)
/*e1: skip*/
e1:
/*printBoolean(t2)*/
	movb	-17(%rbp), %bl
	call	print_boolean
/*t3 = "Hello\n"*/
	movq	str_5@GOTPCREL(%rip), %rax
	movq	%rax, -25(%rbp)
/*t4 = "Hello\n"*/
	movq	str_6@GOTPCREL(%rip), %rax
	movq	%rax, -33(%rbp)
/*if t3 != t4 goto e2*/
	movq	-25(%rbp), %rsi
	movq	-33(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	jne 	e2
/*t5 = 0*/
	movb	$0, %al
	movb	%al, -34(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t5 = -1*/
	movb	$-1, %al
	movb	%al, -34(%rbp)
/*e3: skip*/
e3:
/*printBoolean(t5)*/
	movb	-34(%rbp), %bl
	call	print_boolean
/*t6 = "hello\n"*/
	movq	str_7@GOTPCREL(%rip), %rax
	movq	%rax, -42(%rbp)
/*t7 = "HeLl0\n"*/
	movq	str_8@GOTPCREL(%rip), %rax
	movq	%rax, -50(%rbp)
/*if t6 != t7 goto e4*/
	movq	-42(%rbp), %rsi
	movq	-50(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	jne 	e4
/*t8 = 0*/
	movb	$0, %al
	movb	%al, -51(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t8 = -1*/
	movb	$-1, %al
	movb	%al, -51(%rbp)
/*e5: skip*/
e5:
/*printBoolean(t8)*/
	movb	-51(%rbp), %bl
	call	print_boolean
/*t9 = "hello\n"*/
	movq	str_9@GOTPCREL(%rip), %rax
	movq	%rax, -59(%rbp)
/*t10 = "HeLl0\n"*/
	movq	str_10@GOTPCREL(%rip), %rax
	movq	%rax, -67(%rbp)
/*if t9 = t10 goto e6*/
	movq	-59(%rbp), %rsi
	movq	-67(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	je  	e6
/*t11 = 0*/
	movb	$0, %al
	movb	%al, -68(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t11 = -1*/
	movb	$-1, %al
	movb	%al, -68(%rbp)
/*e7: skip*/
e7:
/*printBoolean(t11)*/
	movb	-68(%rbp), %bl
	call	print_boolean
/*t12 = "Hello, world!\n"*/
	movq	str_11@GOTPCREL(%rip), %rax
	movq	%rax, -84(%rbp)
/*str1 = t12*/
	movq	-84(%rbp), %rax
	movq	%rax, -76(%rbp)
/*t13 = "Hello, world!\n"*/
	movq	str_12@GOTPCREL(%rip), %rax
	movq	%rax, -100(%rbp)
/*str2 = t13*/
	movq	-100(%rbp), %rax
	movq	%rax, -92(%rbp)
/*if str1 = str1 goto e8*/
	movq	-76(%rbp), %rsi
	movq	-76(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	je  	e8
/*t14 = 0*/
	movb	$0, %al
	movb	%al, -101(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t14 = -1*/
	movb	$-1, %al
	movb	%al, -101(%rbp)
/*e9: skip*/
e9:
/*printBoolean(t14)*/
	movb	-101(%rbp), %bl
	call	print_boolean
/*if str1 != str1 goto e10*/
	movq	-76(%rbp), %rsi
	movq	-76(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	jne 	e10
/*t15 = 0*/
	movb	$0, %al
	movb	%al, -102(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t15 = -1*/
	movb	$-1, %al
	movb	%al, -102(%rbp)
/*e11: skip*/
e11:
/*printBoolean(t15)*/
	movb	-102(%rbp), %bl
	call	print_boolean
/*if str1 = str2 goto e12*/
	movq	-76(%rbp), %rsi
	movq	-92(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	je  	e12
/*t16 = 0*/
	movb	$0, %al
	movb	%al, -103(%rbp)
/*goto e13*/
	jmp 	e13
/*e12: skip*/
e12:
/*t16 = -1*/
	movb	$-1, %al
	movb	%al, -103(%rbp)
/*e13: skip*/
e13:
/*printBoolean(t16)*/
	movb	-103(%rbp), %bl
	call	print_boolean
/*if str1 != str2 goto e14*/
	movq	-76(%rbp), %rsi
	movq	-92(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	jne 	e14
/*t17 = 0*/
	movb	$0, %al
	movb	%al, -104(%rbp)
/*goto e15*/
	jmp 	e15
/*e14: skip*/
e14:
/*t17 = -1*/
	movb	$-1, %al
	movb	%al, -104(%rbp)
/*e15: skip*/
e15:
/*printBoolean(t17)*/
	movb	-104(%rbp), %bl
	call	print_boolean
/*t18 = "😀\n"*/
	movq	str_13@GOTPCREL(%rip), %rax
	movq	%rax, -112(%rbp)
/*t19 = "😀\n"*/
	movq	str_14@GOTPCREL(%rip), %rax
	movq	%rax, -120(%rbp)
/*if t18 = t19 goto e16*/
	movq	-112(%rbp), %rsi
	movq	-120(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	je  	e16
/*t20 = 0*/
	movb	$0, %al
	movb	%al, -121(%rbp)
/*goto e17*/
	jmp 	e17
/*e16: skip*/
e16:
/*t20 = -1*/
	movb	$-1, %al
	movb	%al, -121(%rbp)
/*e17: skip*/
e17:
/*printBoolean(t20)*/
	movb	-121(%rbp), %bl
	call	print_boolean
/*t21 = "😀\n"*/
	movq	str_15@GOTPCREL(%rip), %rax
	movq	%rax, -129(%rbp)
/*t22 = "😀\n"*/
	movq	str_16@GOTPCREL(%rip), %rax
	movq	%rax, -137(%rbp)
/*if t21 != t22 goto e18*/
	movq	-129(%rbp), %rsi
	movq	-137(%rbp), %rdi
	call 	compare_strings
	cmpb	$-1, %dl
	jne 	e18
/*t23 = 0*/
	movb	$0, %al
	movb	%al, -138(%rbp)
/*goto e19*/
	jmp 	e19
/*e18: skip*/
e18:
/*t23 = -1*/
	movb	$-1, %al
	movb	%al, -138(%rbp)
/*e19: skip*/
e19:
/*printBoolean(t23)*/
	movb	-138(%rbp), %bl
	call	print_boolean
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/**
 * Compares two strings (saves result to %dl)
 * Params:
 * - %rsi: First string address
 * - %rdi: Second string address
 */
compare_strings:
	lea 	-1(%rsi), %rcx
	lea 	-1(%rdi), %rdx
	.Cloop:
		inc 	%rcx
		inc 	%rdx
		cmpb	$0, (%rcx)
		jne 	.compare_strings_continue
		cmpb	$0, (%rdx)
		je  	.compare_strings_true
		.compare_strings_continue:
			movb	(%rcx), %al
			cmpb	%al, (%rdx)
			je  	.Cloop
	.compare_strings_false:
		movb	$0, %dl
		jmp 	.compare_strings_end
	.compare_strings_true:
		movb	$-1, %dl
	.compare_strings_end:
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
	str_3: .asciz "Hello\n"
	str_4: .asciz "Hello\n"
	str_5: .asciz "Hello\n"
	str_6: .asciz "Hello\n"
	str_7: .asciz "hello\n"
	str_8: .asciz "HeLl0\n"
	str_9: .asciz "hello\n"
	str_10: .asciz "HeLl0\n"
	str_11: .asciz "Hello, world!\n"
	str_12: .asciz "Hello, world!\n"
	str_13: .asciz "😀\n"
	str_14: .asciz "😀\n"
	str_15: .asciz "😀\n"
	str_16: .asciz "😀\n"
