package com.kugou.navigator

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 定义浅色主题配色方案
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0066CC),       // 主色调 - 深蓝色
    onPrimary = Color.White,            // 主色调上的内容色
    primaryContainer = Color(0xFFD6E4FF), // 主色调容器
    onPrimaryContainer = Color(0xFF001C3A), // 主色调容器上的内容色

    secondary = Color(0xFF525F7F),     // 次要色调
    onSecondary = Color.White,          // 次要色调上的内容色
    secondaryContainer = Color(0xFFD9E3FF), // 次要色调容器
    onSecondaryContainer = Color(0xFF0E1C3B), // 次要色调容器上的内容色

    tertiary = Color(0xFF6750A4),      // 第三色调
    onTertiary = Color.White,           // 第三色调上的内容色
    tertiaryContainer = Color(0xFFE9DDFF), // 第三色调容器
    onTertiaryContainer = Color(0xFF22005D), // 第三色调容器上的内容色

    background = Color(0xFFF8F9FC),     // 背景色
    onBackground = Color(0xFF1A1B1E),   // 背景上的内容色

    surface = Color.White,               // 表面色（卡片、列表等）
    onSurface = Color(0xFF1A1B1E),      // 表面上的内容色
    surfaceVariant = Color(0xFFE1E3EC), // 表面变体
    onSurfaceVariant = Color(0xFF44474F), // 表面变体上的内容色

    outline = Color(0xFF74777F),        // 轮廓色
    outlineVariant = Color(0xFFC4C6D0), // 轮廓变体

    error = Color(0xFFBA1A1A),          // 错误色
    onError = Color.White,              // 错误上的内容色
    errorContainer = Color(0xFFFFDAD6), // 错误容器
    onErrorContainer = Color(0xFF410002) // 错误容器上的内容色
)

// 定义深色主题配色方案
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFA8C8FF),        // 主色调 - 浅蓝色
    onPrimary = Color(0xFF00315F),      // 主色调上的内容色
    primaryContainer = Color(0xFF004A87), // 主色调容器
    onPrimaryContainer = Color(0xFFD6E4FF), // 主色调容器上的内容色

    secondary = Color(0xFFBAC7EA),     // 次要色调
    onSecondary = Color(0xFF243155),    // 次要色调上的内容色
    secondaryContainer = Color(0xFF3A4770), // 次要色调容器
    onSecondaryContainer = Color(0xFFD9E3FF), // 次要色调容器上的内容色

    tertiary = Color(0xFFCFBCFF),      // 第三色调
    onTertiary = Color(0xFF381E72),     // 第三色调上的内容色
    tertiaryContainer = Color(0xFF4F378A), // 第三色调容器
    onTertiaryContainer = Color(0xFFE9DDFF), // 第三色调容器上的内容色

    background = Color(0xFF1A1B1E),    // 背景色
    onBackground = Color(0xFFE3E2E6),  // 背景上的内容色

    surface = Color(0xFF1A1B1E),        // 表面色（卡片、列表等）
    onSurface = Color(0xFFE3E2E6),     // 表面上的内容色
    surfaceVariant = Color(0xFF44474F), // 表面变体
    onSurfaceVariant = Color(0xFFC4C6D0), // 表面变体上的内容色

    outline = Color(0xFF8E9099),        // 轮廓色
    outlineVariant = Color(0xFF44474F), // 轮廓变体

    error = Color(0xFFFFB4AB),          // 错误色
    onError = Color(0xFF690005),        // 错误上的内容色
    errorContainer = Color(0xFF93000A), // 错误容器
    onErrorContainer = Color(0xFFFFDAD6) // 错误容器上的内容色
)

// 定义排版样式
private val Typography = androidx.compose.material3.Typography(
    displayLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    displaySmall = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    headlineLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    titleLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = androidx.compose.ui.text.TextStyle(
        fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

// 定义形状样式
private val Shapes = androidx.compose.material3.Shapes(
    extraSmall = androidx.compose.foundation.shape.RoundedCornerShape(4.dp),
    small = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
    medium = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
    large = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
    extraLarge = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)
)

// 主题组合
@Composable
fun AINavigationAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}