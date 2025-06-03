package com.composeuitask.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeuitask.R
import com.composeuitask.ui.theme.colors.MyColors
import com.dailyui001.ui.theme.color.DarkColorPalette
import com.dailyui001.ui.theme.color.LightColorPalette

@Composable
fun SignUpScreen(
    isDarkMode: Boolean = isSystemInDarkTheme()
) {
    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        SignUpScreenLandscape(isDarkMode = isDarkMode)
    } else {
        SignUpScreenPortrait(isDarkMode = isDarkMode)
    }
}

@Composable
fun SignUpScreenPortrait(isDarkMode: Boolean) {
    val colors = if (isDarkMode) DarkColorPalette else LightColorPalette
    val scrollState = rememberScrollState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.bgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.titleHighlight,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Please login or sign up to continue using our app",
                    fontSize = 16.sp,
                    color = colors.subTitleTextColor,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Text(
                    text = "Enter via Social Networks",
                    fontSize = 16.sp,
                    color = colors.subTitleTextColor,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(bottom = 32.dp)
                ) {
                    SocialButton(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_apple),
                        onClick = { }, colors = colors
                    )
                    SocialButton(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_google),
                        onClick = { }, colors = colors
                    )
                }

                Text(
                    text = "or login with\nemail",
                    fontSize = 16.sp,
                    color = colors.subTitleTextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                InputFieldsSection(
                    email = email,
                    password = password,
                    onEmailChange = { email = it },
                    onPasswordChange = { password = it },
                    colors = colors,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.buttonBgColor,
                        contentColor = colors.buttonTextColor
                    ),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = "Create account",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                AlreadyHaveAccountText(colors = colors)

                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                        .align(Alignment.CenterHorizontally)
                )

                TermsAndPrivacyText(colors = colors)

                Spacer(modifier = Modifier.height(16.dp))

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun SignUpScreenLandscape(isDarkMode: Boolean) {
    val colors = if (isDarkMode) DarkColorPalette else LightColorPalette
    val scrollState = rememberScrollState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.bgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = colors.titleHighlight
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Please login or sign up to continue using our app",
                        fontSize = 16.sp,
                        color = colors.subTitleTextColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    // Social login section
                    Text(
                        text = "Enter via Social Networks",
                        fontSize = 16.sp,
                        color = colors.subTitleTextColor,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Social buttons
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.padding(bottom = 20.dp)
                    ) {
                        SocialButton(
                            icon = ImageVector.vectorResource(id = R.drawable.ic_apple),
                            onClick = { }, colors = colors
                        )
                        SocialButton(

                            icon = ImageVector.vectorResource(id = R.drawable.ic_google),
                            onClick = { }, colors = colors
                        )
                    }

                    // Or login with email
                    Text(
                        text = "or login with\nemail",
                        fontSize = 16.sp,
                        color = colors.subTitleTextColor,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    InputFieldsSection(
                        email = email,
                        password = password,
                        onEmailChange = { email = it },
                        onPasswordChange = { password = it },
                        colors = colors,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colors.buttonBgColor,
                            contentColor = colors.buttonTextColor
                        ),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text(
                            text = "Create account",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    AlreadyHaveAccountText(colors = colors)

                    Spacer(modifier = Modifier.height(16.dp))

                    TermsAndPrivacyText(colors = colors)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun InputFieldsSection(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    colors: MyColors,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholder = {
                Text(
                    text = "Your Email",
                    fontSize = 16.sp,
                    color = colors.subTitleTextColor.copy(alpha = 0.6f)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colors.outlineFocused,
                unfocusedBorderColor = colors.outline,
                focusedContainerColor = colors.containerColor,
                unfocusedContainerColor = colors.containerColor,
                focusedTextColor = colors.textColor,
                unfocusedTextColor = colors.textColor
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = {
                Text(
                    text = "Password",
                    fontSize = 16.sp,
                    color = colors.subTitleTextColor.copy(alpha = 0.6f)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colors.outlineFocused,
                unfocusedBorderColor = colors.outline,
                focusedContainerColor = colors.containerColor,
                unfocusedContainerColor = colors.containerColor,
                focusedTextColor = colors.textColor,
                unfocusedTextColor = colors.textColor
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )
    }
}

@Composable
fun SocialButton(
    icon: ImageVector? = null,
    onClick: () -> Unit,
    colors: MyColors
) {
    val isDark = isSystemInDarkTheme()
    val iconTint = if (isDark) Color.White else Color.Unspecified
    val backgroundColor = if (isDark) colors.containerColor else Color.White
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(backgroundColor, CircleShape)
            .border(1.dp, backgroundColor, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = iconTint
            )
        }
    }
}

@Composable
fun AlreadyHaveAccountText(colors: MyColors) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = colors.loginText)) {
            append("Already have an account? ")
        }
        pushStringAnnotation(tag = "LOGIN", annotation = "login")
        withStyle(
            style = SpanStyle(
                color = colors.titleTextColor,
                fontWeight = FontWeight.Medium
            )
        ) {
            append("Login")
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = "LOGIN",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                // Handle login click
            }
        }
    )
}

@Composable
fun TermsAndPrivacyText(colors: MyColors) {
    val termsString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colors.termTextColor,
                fontSize = 12.sp
            )
        ) {
            append("I accept App's ")
        }
        pushStringAnnotation(tag = "TERMS", annotation = "terms")
        withStyle(style = SpanStyle(color = colors.termTextColor, fontSize = 12.sp)) {
            append("Terms of Use")
        }
        pop()
        withStyle(
            style = SpanStyle(
                color = colors.termTextColor,
                fontSize = 12.sp
            )
        ) {
            append(" and ")
        }
        pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
        withStyle(style = SpanStyle(color = colors.termTextColor, fontSize = 12.sp)) {
            append("Privacy Policy")
        }
        pop()
    }

    ClickableText(
        text = termsString,
        onClick = { offset ->
            termsString.getStringAnnotations(
                tag = "TERMS",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                // Handle terms click
            }
            termsString.getStringAnnotations(
                tag = "PRIVACY",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                // Handle privacy click
            }
        },
    )
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}