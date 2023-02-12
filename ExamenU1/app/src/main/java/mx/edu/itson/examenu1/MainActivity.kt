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
               var celsius:Double=etC.toString().toDouble()
               var kelvin:Double=etK.toString().toDouble()
               var fahrenheit:Double=etF.toString().toDouble()
               if(celsius==0.0){
                   if(kelvin!=0.0 && fahrenheit!=0.0){
                       txError.setText("Solo se requiere que ingrese un valor  kelvin o fahrenheit, para que comprenda la conserion")
                   }else{
                       if(kelvin==0.0 && fahrenheit!=0.0 ){
                         etC.setText(calcularCelsius(fahrenheit).toString())
                       }else{
                           etC.setText(calcularKelvinToCelsius(kelvin).toString())
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
                var celsius:Double=etC.toString().toDouble()
                var kelvin:Double=etK.toString().toDouble()
                var fahrenheit:Double=etF.toString().toDouble()
                if(kelvin==0.0){
                    if(celsius!=0.0 && fahrenheit!=0.0){
                        txError.setText("Solo se requiere que ingrese un valor  celsius o fahrenheit, para que comprenda la conserion")
                    }else{
                        if(celsius==0.0 && fahrenheit!=0.0 ){
                            etK.setText(calcularFahrenheitToKelvin(fahrenheit).toString())
                        }else{
                            etK.setText(calcularCelsiusToKelvin(celsius).toString())
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
                var celsius:Double=etC.toString().toDouble()
                var kelvin:Double=etK.toString().toDouble()
                var fahrenheit:Double=etF.toString().toDouble()
                if(fahrenheit==0.0){
                    if(celsius!=0.0 && kelvin!=0.0){
                        txError.setText("Solo se requiere que ingrese un valor  celsius o kelvin, para que comprenda la conserion")
                    }else{
                        if(celsius==0.0 && kelvin!=0.0 ){
                            etF.setText(calcularKelvinToFahrenheit(kelvin).toString())
                        }else{
                            etF.setText(calcularFahrenheit(celsius).toString())
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
    
    fun calcularFahrenheit(celsius:Double): Double{
return ((celsius*1.8)+32)
    }
    fun calcularCelsius(fahrenheit:Double): Double{
        return ((fahrenheit-32)/1.8)
    }
    fun calcularKelvinToCelsius(kelvin:Double):Double{
return (kelvin-273.15)
    }
    fun calcularKelvinToFahrenheit(kelvin:Double):Double{
     return (((9*(kelvin-273.15))/5)+32)
    }
    fun calcularCelsiusToKelvin(celsius:Double):Double{
        return (celsius+273.15)
    }
    fun calcularFahrenheitToKelvin(fahrenheit:Double):Double{
        return (((5*(fahrenheit-32))/9)+273.15)
    }
}