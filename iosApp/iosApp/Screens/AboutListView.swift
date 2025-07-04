//
//  AboutListView.swift
//  iosApp
//
//  Created by Carlos Caño Gómez on 30/6/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutListView: View {
    
  private struct RowItem: Hashable {
    let title: String
    let subtitle: String
  }

  private let items: [RowItem] = {
    let platform = Platform() // Contenido shared
      
    platform.logSystemInfo()

    var result: [RowItem] = [
      .init( title: "Sistema operativo",
             subtitle: "\(platform.osName) \(platform.osVersion)" ),
      .init( title: "Dispositivo",
             subtitle: platform.deviceModel ),
      .init( title: "Densidad de pantalla",
             subtitle: "@\(platform.density)x" )
    ]
      
    return result
  }()

  var body: some View {
    List (items, id: \.self) { item in
        
        VStack(alignment: .leading) {
            
          Text(item.title)
            .font(.footnote)
            .foregroundStyle(.secondary)
            
          Text(item.subtitle)
            .font(.body)
            .foregroundStyle(.primary)
        }
        .padding(.vertical, 4)
    }
  }
}

#Preview {
    AboutListView()
}
