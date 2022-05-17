package br.com.gds.osservices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager

class Bateria : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val nivelDaBateria = intent.getIntExtra("level",0)
        val temperatura = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,-1)
        val voltagem = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,-1)
        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1)
        val vidaBateria = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,-1)
        val capacidade = BatteryManager.BATTERY_PROPERTY_CAPACITY
        val contadorDeCarga = BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER
        val correnteMedia = BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE
        val atual =BatteryManager.BATTERY_PROPERTY_CURRENT_NOW


        _NivelDaBateriaPorcentagem = nivelDaBateria
        _TemperaturaBateria = temperatura
        _VoltagemBateria = voltagem
        _StatusAtual = ChackStatus(status)
        _VidaBateria = ChackHealth(vidaBateria)
        _Capacidadebateria = capacidade

    }

    private fun ChackHealth(vidaBateria: Int): String {
        when(vidaBateria){
            BatteryManager.BATTERY_HEALTH_COLD->{
                return "Cold"
            }
            BatteryManager.BATTERY_HEALTH_DEAD->{
                return "Dead"
            }
            BatteryManager.BATTERY_HEALTH_GOOD->{
                return "Good"
            }
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE->{
                return "Over Voltage"
            }
            BatteryManager.BATTERY_HEALTH_OVERHEAT->{
                return "Overheat"
            }
            BatteryManager.BATTERY_HEALTH_UNKNOWN->{
                return "Unknown"
            }
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE->{
                return "Unspecified Failure"
            }
            else->{
                return "No data"
            }
        }
    }

    private fun ChackStatus(status: Int): String {
        when(status){
            BatteryManager.BATTERY_STATUS_CHARGING->{
                return "Charging"
            }
            BatteryManager.BATTERY_STATUS_DISCHARGING->{
                return "Discharging"
            }
            BatteryManager.BATTERY_STATUS_FULL->{
                return "Full"
            }
            BatteryManager.BATTERY_STATUS_NOT_CHARGING->{
                return "Not Charging"
            }
            BatteryManager.BATTERY_STATUS_UNKNOWN->{
                return "Unknown"
            }
            else->{
                return "Sem dados"
            }
        }
    }

    companion object Info{
        var _NivelDaBateriaPorcentagem = 0
        var _TemperaturaBateria = 0
        var _VoltagemBateria = 0
        var _StatusAtual = ""
        var _VidaBateria = ""
        var _Capacidadebateria = 0
    }
}