import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { InterpolationComponent } from './components/interpolation/interpolation.component';
import { DirectivesComponent } from './components/directives/directives.component';


@NgModule({
    declarations: [
        AppComponent,
        InterpolationComponent,
        DirectivesComponent
    ],
    imports: [
        BrowserModule,
        FormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }