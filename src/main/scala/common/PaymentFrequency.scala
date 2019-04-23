package common

sealed trait PaymentFrequency
case object Annual extends PaymentFrequency
case object SemiAnnual extends PaymentFrequency
