package br.me.dio.businesscard

import android.app.Application
import br.me.dio.businesscard.data.AppDatabase
import br.me.dio.businesscard.data.BusinessCardRepository

//Classe inicializadora
class App : Application() {
  val database by lazy { AppDatabase.getDatabase(this) }
  val repository by lazy { BusinessCardRepository(database.businessDao()) }
}