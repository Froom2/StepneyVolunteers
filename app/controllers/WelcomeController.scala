package controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

class WelcomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def welcome() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.welcome())
  }

  def thankyou() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.thankyou())
  }
}
