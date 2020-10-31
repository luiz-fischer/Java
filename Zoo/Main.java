package Zoo;
/**
 * License Copyright: Luiz Otávio Fischer.
   License License: Open-source.
   License Contact: Unknown.

   Copyright <2020> <Luiz Otavio Fischer>

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
    End license text.
 */
public class Main {
    public static void main(String[] args) {

        Mamifero girafa = new Mamifero("Girafa", 6.25, 4, "Amarelo e Preto", "Savanas Áfricanas", "Herbívoro");

        Peixe peixePalhaco = new Peixe("Peixe Palhaço", 17, 0, "Laranja e Branco", "Oceanos índico e Pacífico.", true );

        System.out.println(girafa);
        System.out.println(peixePalhaco);
    }
}
