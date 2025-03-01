import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory"      % "0.18.0"  % Test,
    "org.scalatest"       %% "scalatest"              % "3.2.0"   % Test,
    "org.scalatestplus"   %% "selenium-3-141"         % "3.2.0.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"           % "0.35.10" % Test,
    "io.cucumber"         %% "cucumber-scala"         % "6.9.1"   % Test,
    "io.cucumber"          % "cucumber-junit"         % "6.9.1"   % Test,
    "info.cukes"          %% "cucumber-scala"         % "1.2.5"   % Test,
    "info.cukes"           % "cucumber-junit"         % "1.2.5"   % Test,
    "info.cukes"           % "cucumber-picocontainer" % "1.2.5"   % Test,
    "junit"                % "junit"                  % "4.12"    % Test,
    "com.novocode"         % "junit-interface"        % "0.11"    % Test,
    "uk.gov.hmrc"         %% "zap-automation"         % "2.9.0"   % Test,
    "com.typesafe"         % "config"                 % "1.3.2"   % Test,
    "org.mongodb.scala"   %% "mongo-scala-driver"     % "2.6.0"   % Test
  )

}
