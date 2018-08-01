package controllers.arrival

import javax.inject.Inject

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import services.TimeService

class ArrivalController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def arrivalMonth() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.arrival.arrival_month(TimeService.months))
  }

  def selectArrivalMonth(month: String) = Action { implicit request: Request[AnyContent] =>
    Redirect(controllers.routes.WelcomeController.welcome())
  }

  def arrivalDay() = Action { implicit request: Request[AnyContent] =>
    Ok("")
  }

}
