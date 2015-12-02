.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static b I
.field private static c I
.field private static doDob F
.field private static str Ljava/lang/String;

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 4
    putstatic Test/a I
    ldc 5
    putstatic Test/b I
    ldc 10
    putstatic Test/c I
    ldc 5
    ldc 4
    iadd
    putstatic Test/c I
    ldc "C is"
    getstatic Test/c I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "C is"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/c I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc 10.2
    putstatic Test/doDob F
    ldc "hello"
    putstatic Test/str Ljava/lang/String;
    ldc 5

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "5"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "hello"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "hello"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "printing Double "
    getstatic Test/doDob F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "printing Double "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/doDob F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "print String "
    getstatic Test/str Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "print String "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/str Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "multiple variable "
    getstatic Test/a I
    getstatic Test/doDob F

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "multiple variable "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    getstatic Test/doDob F
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "Initial"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Initial"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/a I
    getstatic Test/b I
    iadd
    putstatic Test/a I
    ldc "Plus equals"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Plus equals"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/a I
    getstatic Test/b I
    isub
    putstatic Test/a I
    ldc "Minus equals"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Minus equals"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/a I
    getstatic Test/b I
    imul
    putstatic Test/a I
    ldc "Mult equals"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Mult equals"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/a I
    getstatic Test/b I
    idiv
    putstatic Test/a I
    ldc "Div equals"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Div equals"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ldc "Initial"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Initial"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/a I
ldc 1
    iadd
    putstatic Test/a I
    ldc "Increment operator"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Increment operator"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic Test/a I
ldc 1
    isub
    putstatic Test/a I
    ldc "Decrement operator"
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Decrement operator"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


return
.limit locals 32
.limit stack 32
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Test/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Test/_standardIn LPascalTextIn;

 new Test
    dup
    invokespecial Test/<init>()V
    invokevirtual Test/main()V

    getstatic	Test/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
