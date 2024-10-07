package com.at.apuestatotal.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary


@Composable
fun MCBaseTextField(
    modifier: Modifier = Modifier,
    textFieldColor: Color = Primary.Red,
    textColor: Color = Color.Gray,
    icon: Painter? = null,
    iconSize: Dp = 22.dp,
    borderColor: Color = Secondary.GrayPrime,
    tintColor: Color = Secondary.GrayPrime,
    hint: String = "",
    textValue: String,
    textAlign: TextAlign = TextAlign.Unspecified,
    textFontSize: TextUnit = TextUnit.Unspecified,
    textFontFamily: FontFamily? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onValueChange: (value: String) -> Unit,
    trailingIcon: @Composable (() -> Unit) = {},
    enabled: Boolean = true,
    onFocused: (Boolean) -> Unit = {},
    selectAllOnFocus: Boolean = false,
    singleLine: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (isFocused) textFieldColor else borderColor, label = ""
    )

    Row(
        modifier = modifier
            .width(200.dp)
            .height(35.dp)
            .border(1.dp, color, RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Icon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(iconSize),
                painter = icon,
                contentDescription = "",
                tint = color
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {
            if (textValue.isEmpty()) {
                Text(
                    text = hint,
                    color = textColor,
                    modifier = Modifier,
                    maxLines = 1,
                    textAlign = textAlign,
                    fontSize = textFontSize,
                    fontFamily = textFontFamily,
                    overflow = TextOverflow.Ellipsis
                )
            }

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        onFocused(focusState.isFocused)
                        if (focusState.isFocused && selectAllOnFocus) {
                            onValueChange("")
                        }
                    },
                value = textValue,
                onValueChange = {
                    onValueChange(it)
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                textStyle = TextStyle(
                    textAlign = textAlign,
                    fontSize = textFontSize,
                    fontFamily = textFontFamily,
                ),
                enabled = enabled,
                singleLine = singleLine
            )
        }

        trailingIcon()
    }
}