package com.example.basic_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberAsyncImagePainter
import com.example.basic_mvvm.ViewModel.MainViewModel
import com.example.basic_mvvm.ViewModel.MainViewmodelFactory
import com.example.basic_mvvm.ui.theme.Basic_MVVMTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewmodelFactory: MainViewmodelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        (application as MyApplication).applicationComponent.inject(this)

        mainViewModel=ViewModelProvider(this,mainViewmodelFactory).get(MainViewModel::class.java)

        setContent {

            Basic_MVVMTheme {


                LaunchedEffect(Unit, block = {
                    mainViewModel.fetchRepo()
                })

//                var products:List<Products> = listOf()
                if (mainViewModel.product.isNotEmpty()) {
                    Log.d("TAG", "onCreate: ${mainViewModel.product.size}")
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        
                        LazyColumn( )
                        {


                            items(mainViewModel.product){ p->
                                Card(Modifier.fillMaxWidth(), elevation = 15.dp)
                                {
                                    Row(Modifier.fillMaxWidth())
                                    {
                                        Column(Modifier.weight(1f))
                                        {
                                            Image(
                                                painter = rememberAsyncImagePainter("${p.image}"),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(100.dp)
                                                    .padding(horizontal = 5.dp, vertical = 10.dp)
                                            )
                                            Text(p.title,maxLines=3, overflow = TextOverflow.Ellipsis)

                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(
                                            Modifier
                                                .weight(3f)
                                                .fillMaxHeight(), verticalArrangement = Arrangement.Center)
                                        {
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(p.description, overflow = TextOverflow.Ellipsis)
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(Modifier.fillMaxSize(), )
                                            {
                                                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "")
                                                Spacer(modifier = Modifier.width(10.dp))

                                                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")

                                            }
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(3.dp))
                            }
                        
                    }
                } }else {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {

                        Box(contentAlignment = Alignment.Center) {

;
                          CircularProgressIndicator(
                              Modifier.size(30.dp)
                          )

                        }
                    }
                }

                }
            }
        }
    }


