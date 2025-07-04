//
//  ArticlesViewModelWrapper.swift
//  iosApp
//
//  Created by Carlos Caño Gómez on 1/7/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen {
    
    // Es una clase que nos va a permitir observar el estado de ArticlesViewModel, sim`plemente un wrapper va a envolver a ArticlesViewModel pero compartiendo su estado
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel // como es una clase que va a envolver a ArticlesViewModel, primero la vamos a definir
        @Published var articlesState: ArticlesState // aqui exponemos al dato real
        
        // Instanciamos las dos variables
        init() {
            articlesViewModel = ArticlesInjector().articlesViewModel // ArticlesViewModel( useCase: ArticlesUseCase(repo: ArticlesRepository(service: ArticlesService(httpClient: httpClient))) )
            articlesState = articlesViewModel.articlesState.value
        }
        
        // Exponemos la función publica para la interfaz de usuario, que se llama en la observación inicial
        // y que se encargará de observar los cambios en el estado de ArticlesViewModel
        func startObserving() {
            Task {
                for await articlesS in articlesViewModel.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}
