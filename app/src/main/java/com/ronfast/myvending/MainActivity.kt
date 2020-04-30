package com.ronfast.myvending

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonBis = findViewById<Button>(R.id.button)
        val buttonChips = findViewById<Button>(R.id.button2)
        val buttonOreo = findViewById<Button>(R.id.button3)
        val buttonTango = findViewById<Button>(R.id.button4)
        val buttonCokelat = findViewById<Button>(R.id.button5)
        val nomuang = findViewById<EditText>(R.id.editText)
        val bayar =findViewById<Button>(R.id.button6)
        val tstokbis = findViewById<TextView>(R.id.stkbis)
        val tstokchips = findViewById<TextView>(R.id.stkchips)
        val tstokoreo = findViewById<TextView>(R.id.stkoreo)
        val tstoktango = findViewById<TextView>(R.id.stktango)
        val tstokcokelat = findViewById<TextView>(R.id.stkcokelat)
        val tsaldo = findViewById<TextView>(R.id.textView3)
        var statnom = "0"
        var stokbis : Int = 5
        var stokchips : Int = 8
        var stokoreo : Int = 3
        var stoktango : Int = 4
        var stokcokelat : Int = 1
        val builder = AlertDialog.Builder(this)
        var lastsaldo : Int = 0

        tstokbis.setText(stokbis.toString())
        tstokchips.setText(stokchips.toString())
        tstokoreo.setText(stokoreo.toString())
        tstoktango.setText(stoktango.toString())
        tstokcokelat.setText(stokcokelat.toString())


        builder.setTitle("Vending Rules")
        builder.setMessage(" -Masukkan nominal Uang" +
                "\n -Klik BAYAR untuk menambah saldo atau uang"+
                "\n -Pastikan Uang atau Saldo mencukupi"+
                "\n -Pilih makanan"+
                "\n -Ambil makanan dan kembalian")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
        }

        builder.show()


        fun proses() {
            if (nomuang.text.isNullOrEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "nominal uang tidak terdeteksi!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                var ceknom = nomuang.text.toString()
                //var statnom = "0"
                var nomint = ceknom.toInt()
                if (ceknom.equals("2000") || ceknom.equals("5000") || ceknom.equals("10000") || ceknom.equals(
                        "20000"
                    ) || ceknom.equals("50000")
                ) {
                    statnom = "1"
                }
            }
        }

        bayar.setOnClickListener {

            if (nomuang.text.isNullOrEmpty()){
            Toast.makeText(applicationContext, "masukkan uang terlebih dahulu!", Toast.LENGTH_SHORT)
                .show()
            } else {
                var strsalnow = tsaldo.text.toString()
                var salnow = strsalnow.toInt()
                var strnom  = nomuang.text.toString()
                var nomku = strnom.toInt()
                lastsaldo = salnow + nomku
                tsaldo.setText(lastsaldo.toString())
            }
        }

        buttonBis.setOnClickListener {
            proses()
            if (statnom.equals("0")) {
                Toast.makeText(
                    applicationContext,
                    "Nominal uang tidak terdeteksi!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (stokbis > 0) {
                    val hargabis: Int = 6000
                    val strnom = nomuang.text.toString()
                    val nomku = strnom.toInt()
                    val kembalian = lastsaldo - hargabis

                    if (kembalian < 0) {
                        Toast.makeText(
                            applicationContext,
                            "Uangnya kurang woi!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        var newstokbis = stokbis - 1
                        stokbis = newstokbis
                        Toast.makeText(
                            applicationContext,
                            "Kembalian anda :  " + kembalian + " Terima Kasih",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    if (stokbis <= 0) {
                        Toast.makeText(
                            applicationContext,
                            "stok biskuit habis!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    tstokbis.setText(stokbis.toString())
//                Toast.makeText(applicationContext, "stok biskuit " + newstokbis, Toast.LENGTH_SHORT)
//                    .show()
                } else {
                    Toast.makeText(applicationContext, "stok biskuit habis!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        buttonChips.setOnClickListener {
            proses()
            if (statnom.equals("0")) {
                Toast.makeText(
                    applicationContext,
                    "Nominal uang tidak terdeteksi!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (stokchips > 0) {

                    val hargachips: Int = 8000
                    val strnom = nomuang.text.toString()
                    val nomku = strnom.toInt()
                    val kembalian = lastsaldo - hargachips

                    if (kembalian < 0) {
                        Toast.makeText(
                            applicationContext,
                            "Uangnya kurang woi!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        var newstokchips = stokchips - 1
                        stokchips = newstokchips
                        Toast.makeText(
                            applicationContext,
                            "Kembalian anda :  " + kembalian + " Terima Kasih",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    if (stokchips <= 0) {
                        Toast.makeText(applicationContext, "stok chips habis!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    tstokchips.setText(stokchips.toString())
//                    Toast.makeText(
//                        applicationContext,
//                        "stok chips " + newstokchips,
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
                } else {
                    Toast.makeText(applicationContext, "stok chips habis!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        buttonOreo.setOnClickListener {
            proses()
            if (statnom.equals("0")) {
                Toast.makeText(
                    applicationContext,
                    "Nominal uang tidak terdeteksi!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (stokoreo > 0) {

                    val hargaoreo: Int = 10000
                    val strnom = nomuang.text.toString()
                    val nomku = strnom.toInt()
                    val kembalian = lastsaldo - hargaoreo

                    if (kembalian < 0) {
                        Toast.makeText(
                            applicationContext,
                            "Uangnya kurang woi!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        var newstokoreo = stokoreo - 1
                        stokoreo = newstokoreo
                        Toast.makeText(
                            applicationContext,
                            "Kembalian anda :  " + kembalian + " Terima Kasih",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    if (stokoreo <= 0) {
                        Toast.makeText(applicationContext, "stok oreo habis!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    tstokoreo.setText(stokoreo.toString())
//                    Toast.makeText(
//                        applicationContext,
//                        "stok oreo " + newstokoreo,
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
                } else {
                    Toast.makeText(applicationContext, "stok oreo habis!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        buttonTango.setOnClickListener {
            proses()
            if (statnom.equals("0")) {
                Toast.makeText(
                    applicationContext,
                    "Nominal uang tidak terdeteksi!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (stoktango > 0) {

                    val hargatango: Int = 12000
                    val strnom = nomuang.text.toString()
                    val nomku = strnom.toInt()
                    val kembalian = lastsaldo - hargatango

                    if (kembalian < 0) {
                        Toast.makeText(
                            applicationContext,
                            "Uangnya kurang woi!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        var newstoktango = stoktango - 1
                        stoktango = newstoktango
                        Toast.makeText(
                            applicationContext,
                            "Kembalian anda :  " + kembalian + " Terima Kasih",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    if (stoktango <= 0) {
                        Toast.makeText(applicationContext, "stok tango habis!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    tstoktango.setText(stoktango.toString())
//                    Toast.makeText(
//                        applicationContext,
//                        "stok tango " + newstoktango,
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
                } else {
                    Toast.makeText(applicationContext, "stok tango habis!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        buttonCokelat.setOnClickListener {
            proses()
            if (statnom.equals("0")) {
                Toast.makeText(
                    applicationContext,
                    "Nominal uang tidak terdeteksi!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (stokcokelat > 0) {

                    val hargacokelat: Int = 15000
                    val strnom = nomuang.text.toString()
                    val nomku = strnom.toInt()
                    val kembalian = lastsaldo - hargacokelat

                    if (kembalian < 0) {
                        Toast.makeText(
                            applicationContext,
                            "Uangnya kurang woi!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        var newstokcokelat = stokcokelat - 1
                        stokcokelat = newstokcokelat
                        Toast.makeText(
                            applicationContext,
                            "Kembalian anda :  " + kembalian + " Terima Kasih",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                    if (stokcokelat <= 0) {
                        Toast.makeText(
                            applicationContext,
                            "stok cokelat habis!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    tstokcokelat.setText(stokcokelat.toString())
//                    Toast.makeText(
//                        applicationContext,
//                        "stok cokelat " + newstokcokelat,
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
                } else {
                    Toast.makeText(applicationContext, "stok cokelat habis!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
