package by.ssrlab.nasguide.di

import by.ssrlab.nasguide.di.network.networkModule
import by.ssrlab.nasguide.di.network.repositoriesModule

val domainModule = networkModule + repositoriesModule