package com.kugou.navigator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WebsiteCard(website: AIWebsite, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 使用缓存管理的图标加载
            FaviconImage(url = website.faviconUrl)

//            AsyncImage(
//                model = website.faviconUrl,
//                contentDescription = "${website.name}图标",
//                modifier = Modifier.size(32.dp),
//                placeholder = painterResource(R.drawable.ic_default_favicon),
//                error = painterResource(R.drawable.ic_default_favicon),
//                contentScale = ContentScale.Crop
//            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = website.name,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = website.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}