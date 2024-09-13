# Código Python gerado

def main():
    palavra = ''
    a = 0
    b = 0
    fazoele = 0
    c = 0
    d = 0
    a = int(input())
    b = int(input())
    print("somando 2 no a")
    a += 2
    print(a)
    print("")
    print("")
    fazoele = 123.34
    print(fazoele)
    palavra = "Abacaxi"
    print("oi")
    print(palavra)
    if a == b:
        print("a igual b")

    else:
        print("a eh diferente de  b")

    print("Teste do While Printando a ate b")
    print("a vale:")
    print(a)
    print("b vale:")
    print(b)
    print("--- Inicio do teste While ---")
    while a<=b:
        print(a)
        a += 1
    print("--- FEIN ---")
    print(" ------------------ ")
    print("Teste do Do-While Printando 4 a 10")
    print(a)
    print(b)
    while True:
        a += 1
        print(a)
        if not (a<10):
            break
    d = 10
    print(d)

if __name__ == '__main__':
    main()

