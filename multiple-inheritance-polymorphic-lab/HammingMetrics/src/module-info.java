module atu.character.metrics {
 requires atu.character.service;
 exports ie.atu.sw.hamming;
 provides ie.atu.character.Measurable with ie.atu.sw.hamming.HammingImpl;
}