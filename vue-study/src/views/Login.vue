<template>
    <div class="fill-height">
        <v-container class="fill-height">
            <v-row align="center" class="fill-height" justify="center">
                <div class="login text-center elevation-15">
                    <h3 class="mb-4 font-weight-bold black--text">로그인</h3>
                    <div>
                        <v-form class="pa-3 text-center" ref="form">

                            <v-text-field :rules="emailRules"
                                          label="E-mail" prepend-icon="mdi-email" required
                                          type="email" v-model="member.email"></v-text-field>

                            <v-text-field :rules="passwordRules"
                                          label="Password" prepend-icon="mdi-lock"
                                          @keyup.enter="loginRequest"
                                          required type="password" v-model="member.password"></v-text-field>

                            <v-btn :loading="loadingState" @click="loginRequest" class="mt-3" color="cyan" outlined>
                                LOGIN
                            </v-btn>
                        </v-form>
                        <p class="mt-3 mb-0 black--text">아직 회원이 아니신가요?
                            <router-link class="font-weight-bold red--text sm"
                                         to="/register">회원가입
                            </router-link>
                        </p>
                    </div>
                </div>
            </v-row>
        </v-container>
        <Modal/>
    </div>
</template>

<script>
    import Modal from "../components/Modal";

    export default {
        name: "Login",
        data() {
            return {
                member: {
                    email: '',
                    password: '',
                },
            }
        },
        computed: {
            emailRules() {
                return this.$store.state.common.emailRules;
            },
            loadingState() {
                return this.$store.state.common.loadingState;
            },
            passwordRules() {
                return this.$store.state.common.passwordRules;
            }
        },
        components: {
            Modal
        },
        methods: {
            loginRequest() {
                if (this.$refs.form.validate()) {
                    this.$store.dispatch('REQUEST_LOGIN', this.member);
                }
            },
        }
    }
</script>

<style scoped>

    @media (min-width: 700px) {
        .login {
            width: 360px !important;
        }
    }

    .login {
        width: 80%;
        background-color: white;
        border-radius: 8px;
        border: white 1px solid;
        padding: 40px;
    }

</style>