package com.asiergilaber.foodapp.signin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.asiergilaber.foodapp.composables.InputTextBasic
import androidx.compose.runtime.collectAsState
import com.asiergilaber.foodapp.composables.PrimaryBtn
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.asiergilaber.foodapp.R
import com.asiergilaber.foodapp.ui.theme.YellowMain


@Composable
fun SignInScreen(signInViewModel: SignInViewModel , modifier: Modifier = Modifier) {

    val email: String by signInViewModel.email.collectAsState()
    val password: String by signInViewModel.password.collectAsState()

    Box(modifier = modifier
        .padding(16.dp)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
            Column {
                Column(modifier = modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(id = R.drawable.logo ),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(180.dp)
                    )
                    Text(text = "NoshUp",
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold ,
                            textAlign = TextAlign.Center,
                            color = YellowMain
                        ))
                }
                InputTextBasic(
                    value = email,
                    label = "Email",
                    onTextChanged = {signInViewModel.onEmailOrPasswordChanged(it, password)},
                    placeholder = "Email",
                    keyboardType = KeyboardType.Email
                )

//                if (emailWrong.isNotEmpty() && emailChange) {
//                    Text(
//                        text = emailWrong,
//                        modifier = modifier,
//                        color = MaterialTheme.colorScheme.error
//                    )
//                }

                Spacer(modifier = Modifier.size(16.dp))
                InputTextBasic(
                    value = password,
                    label = "Password",
                    onTextChanged = {signInViewModel.onEmailOrPasswordChanged(email, it)},
                    placeholder = "Password",
                    keyboardType = KeyboardType.Password
                )
                Spacer(modifier = Modifier.size(16.dp))

                TextButton(onClick = { signInViewModel.navigateSignUp() }) {
                    Text(text = "Don’t have an account? Register now!" ,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp, top = 15.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                    )
                }

               PrimaryBtn(text = "Sign In", onClick = { signInViewModel.onSignInButtonClicked() })

    }

}
}

