import SwiftUI
import shared // Importa el módulo compartido que contiene la lógica de negocio y los modelos

@main
struct iOSApp: App {
    
    init() {
        KoinInitializerKt.doInitKoin()
      }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
