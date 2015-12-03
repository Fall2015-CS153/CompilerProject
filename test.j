.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static bor Z
.field private static c I
.field private static doDob F
.field private static fort F
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
    ldc 10.2
    putstatic Test/doDob F
    ldc "hello"
    putstatic Test/str Ljava/lang/String;
    ldc 1
    putstatic Test/bor Z
    ldc 5

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "5"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "hello"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "hello"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    ldc "Printing Boolean "
    getstatic Test/bor Z

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing Boolean "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/bor Z
    invokevirtual java/lang/StringBuilder/append(Z)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "Printing integer "
    getstatic Test/a I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Printing integer "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/a I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
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

    pop
    pop
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

    pop
    pop
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

    pop
    pop
    pop
    ldc "Exiting FirstProcedure"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Exiting FirstProcedure"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    new Test
    dup
    invokespecial Test/<init>()V
    invokevirtual Test/second()V
    ldc "Entering back in first Procedure"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Entering back in first Procedure"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop

return
.limit locals 32
.limit stack 32
.end method

.method public second()V
    ldc 5
    putstatic Test/c I
    ldc 6.0
    putstatic Test/fort F
    ldc "Entered and Leaving second procedure"

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Entered and Leaving second procedure"
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop

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
