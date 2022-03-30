package SimulacroExamen;

import org.testng.annotations.DataProvider;

public class DataProviderGenerator {
    @DataProvider(name="passwords")
    public Object [][] typeOfPassrords(){
        return new Object[][]{
                {"11","11","LONGITUD_INCORRECTA"},
                {"4444444444","4444444444","FALTA_MAYUSCULA"},
                {"AAAAAAAAAA","AAAAAAAAAA","FALTA_NUMERO"},
                {"Test123456789","Test12345678900","NO_COINCIDEN"},
                {"Test123456789","Test123456789","CORRECTO"}
        };
    }
}
