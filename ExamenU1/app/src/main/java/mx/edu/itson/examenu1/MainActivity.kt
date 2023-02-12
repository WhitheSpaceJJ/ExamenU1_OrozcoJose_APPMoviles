package mx.edu.itson.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txError: TextView =findViewById(R.id.txtError)
        val etC: EditText =findViewById(R.id.etC)
        val etF: EditText =findViewById(R.id.etF)
        val etK: EditText =findViewById(R.id.etK)
        val btnC: Button = findViewById(R.id.btnGC)
        val btnF: Button = findViewById(R.id.btnGF)
        val btnK: Button = findViewById(R.id.btnGK)
        btnC.setOnClickListener {
          txError.setText("")
           if(etC.toString().isEmpty()==false || etF.toString().isEmpty()==false || etK.toString().isEmpty()==false){
               var celsius:Double=0.0
               var kelvin:Double=0.0
               var fahrenheit:Double=0.0
               try{
                   celsius=etC.text.toString().toDouble()
                   kelvin=etK.text.toString().toDouble()
                    fahrenheit=etF.text.toString().toDouble()
               }catch(e:java.lang.Exception){
                   txError.setText("Ha ingresado valores no validos")
               }
               if(celsius==0.0){
                   if(kelvin!=0.0 && fahrenheit!=0.0){
                       txError.setText("Solo se requiere que ingrese un valor  kelvin o fahrenheit, para que comprenda la conserion")
                   }else{
                       if(kelvin==0.0 && fahrenheit!=0.0 ){
                         etC.setText("%.4f".format(calcularFahrenheitToCelsius(fahrenheit)))
                       }else{
                           etC.setText("%.4f".format(calcularKelvinToCelsius(kelvin)))
                       }
                   }
               }else{
                   txError.setText("No se puede realizar una conversion de celsius a celsius")
               }
           }else{
               txError.setText("Se requiere que ingrese algun valor antes de realizar alguna conversion")
           }
        }
        btnK.setOnClickListener {
            txError.setText("")
            if(etC.toString().isEmpty()==false || etF.toString().isEmpty()==false || etK.toString().isEmpty()==false){
                var celsius:Double=0.0
                var kelvin:Double=0.0
                var fahrenheit:Double=0.0
                try{
                    celsius=etC.text.toString().toDouble()
                    kelvin=etK.text.toString().toDouble()
                    fahrenheit=etF.text.toString().toDouble()
                }catch(e:java.lang.Exception){
                    txError.setText("Ha ingresado valores no validos")
                }
                if(kelvin==0.0){
                    if(celsius!=0.0 && fahrenheit!=0.0){
                        txError.setText("Solo se requiere que ingrese un valor  celsius o fahrenheit, para que comprenda la conserion")
                    }else{
                        if(celsius==0.0 && fahrenheit!=0.0 ){
                            etK.setText("%.4f".format(calcularFahrenheitToKelvin(fahrenheit)))
                        }else{
                            etK.setText("%.4f".format(calcularCelsiusToKelvin(celsius)))
                        }
                    }
                }else{
                    txError.setText("No se puede realizar una conversion de kelvin a kelvin")
                }
            }else{
                txError.setText("Se requiere que ingrese algun valor antes de realizar alguna conversion")
            }
        }
        btnF.setOnClickListener {
            txError.setText("")
            if(etC.toString().isEmpty()==false || etF.toString().isEmpty()==false || etK.toString().isEmpty()==false){
                var celsius:Double=0.0
                var kelvin:Double=0.0
                var fahrenheit:Double=0.0
                try{
                    celsius=etC.text.toString().toDouble()
                    kelvin=etK.text.toString().toDouble()
                    fahrenheit=etF.text.toString().toDouble()
                }catch(e:java.lang.Exception){
                    txError.setText("Ha ingresado valores no validos")
                }
                if(fahrenheit==0.0){
                    if(celsius!=0.0 && kelvin!=0.0){
                        txError.setText("Solo se requiere que ingrese un valor  celsius o kelvin, para que comprenda la conserion")
                    }else{
                        if(celsius==0.0 && kelvin!=0.0 ){
                            etF.setText("%.4f".format(calcularKelvinToFahrenheit(kelvin)))
                        }else{
                            etF.setText("%.4f".format(calcularCelsiusToFahrenheit(celsius)))
                        }
                    }
                }else{
                    txError.setText("No se puede realizar una conversion de fahrenheit a fahrenheit")
                }
            }else{
                txError.setText("Se requiere que ingrese algun valor antes de realizar alguna conversion")
            }
        }
    }
    

    fun calcularFahrenheitToCelsius(fahrenheit:Double): Double{
        return ((fahrenheit-32)*(5/9))
    }

    fun calcularKelvinToCelsius(kelvin:Double):Double{
return (kelvin-273.15)
    }

    fun calcularCelsiusToFahrenheit(celsius:Double): Double{
        return ((celsius*(9/5))+32)
    }
    fun calcularKelvinToFahrenheit(kelvin:Double):Double{
     return ((((kelvin-273.15))*(9/5))+32)
    }
    fun calcularCelsiusToKelvin(celsius:Double):Double{
        return (celsius+273.15)
    }
    fun calcularFahrenheitToKelvin(fahrenheit:Double):Double{
        return ((((fahrenheit-32))*(5/9))+273.15)
    }
}