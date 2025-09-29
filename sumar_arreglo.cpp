#include <iostream>
#include <vector>

int sumar_arreglo(const std::vector<int>& arr) {
    int suma = 0;
    for (int elemento : arr) {
        suma += elemento;
    }
    return suma;
}

int main() {
    std::vector<int> mis_numeros = {10, 20, 30, 40, 50};
   
    int resultado = sumar_arreglo(mis_numeros);
    
    std::cout << "La suma de los elementos es: " << resultado << std::endl;
    
    return 0; 
}
