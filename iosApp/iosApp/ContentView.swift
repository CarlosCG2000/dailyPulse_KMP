import SwiftUI
import shared // Contiene dentro de la carpeta 'shared' -> el 'commonMain' y 'iosMain' (pero no el 'androidMain')

struct ContentView: View {
	// let greet = Greeting().greet() // "Hello, ${platform.name}!"
    @State private var shouldOpenAbout = false

	var body: some View {
        let articlesScreen = ArticlesScreen(viewModel: .init())
        
        NavigationStack{
                   ArticlesScreen(viewModel: .init())
                       .toolbar {
                           ToolbarItem {
                               Button {
                                   shouldOpenAbout = true
                               } label: {
                                   Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                               }
                               .popover(isPresented: $shouldOpenAbout) {
                                   AboutScreen()
                               }
                           }
                       }
        }.refreshable {
            articlesScreen.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }
   }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
